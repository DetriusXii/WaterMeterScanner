package ca.regina.barcodescanner

import android.app._
import android.os.Bundle
import android.view._
import android.widget._
import android.content._
import android.location._

class WorkOrderDetail extends Fragment {

  def getShownIndex: Int = getArguments.getInt(WorkOrderDetail.LIST_INDEX_KEY)
  def getSentence: String = getArguments.getString(WorkOrderDetail.SENTENCE_KEY)
  private var workDetailsLayout: View = null 
  
  
  private def setScanBarcodeButton(workDetailsLayout: View): Unit = {
    val button = 
      workDetailsLayout.findViewById(R.id.scan_barcode).asInstanceOf[Button]
    val buttonOption = if (button != null) {Some(button)} else {None}
    buttonOption.map((button: Button) => {
      button.setOnClickListener(new View.OnClickListener {
        def onClick(view: View): Unit = {
          val intent = new Intent(WorkOrdersActivity.SCAN_INTENT)
          intent.setPackage(WorkOrdersActivity.PACKAGE_NAME)
          intent.putExtra(WorkOrdersActivity.SCAN_MODE, 
        		  WorkOrdersActivity.QR_CODE_MODE)
          
          try {
		    WorkOrderDetail.this.startActivityForResult(intent, 0)
		  } catch {
		    case _: ActivityNotFoundException => 
		      Toast.makeText(getActivity, 
		          R.string.no_zxing_scanner, 
		          Toast.LENGTH_SHORT).show
		  }
        }
      })
    })
    
  }
  
  def getGPSLocation: Option[String] = {
    val locationManager = getActivity.
    	getSystemService(Context.LOCATION_SERVICE).
    	asInstanceOf[LocationManager]
    val gpsProvider =
      locationManager.getProvider(LocationManager.GPS_PROVIDER)
    val gpsProviderOption = 
      if (gpsProvider != null) {Some(gpsProvider)} else {None}
    gpsProviderOption.map((gpsProvider: LocationProvider) => {
      locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,
    		  new LocationListener {
    	  		override def onLocationChanged(location: Location): Unit = {
    	  		  
    	  		}
      		  }
      )
    })
    
      locationManager.requestSingleUpdate(
        LocationManager.GPS_PROVIDER)
  }
  
  override def onActivityResult(requestCode: Int,
	    resultCode: Int, intent: Intent): Unit = {
	  if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
	    val contents = 
	      intent.getStringExtra(WorkOrdersActivity.SCAN_RESULT)
	    val format = 
	      intent.getStringExtra(WorkOrdersActivity.SCAN_RESULT_FORMAT)
	    
	    val barcodeValue = workDetailsLayout.
	    	findViewById(R.id.barcode_value).
	    	asInstanceOf[TextView]
	    val barcodeValueOption = 
	      if (barcodeValue != null) {Some(barcodeValue)} else {None}
	    barcodeValueOption.map((barcodeValue: TextView) => {
	      barcodeValue.setText(contents)
	    })
	    
	    
	  } else if (requestCode == 0 && resultCode == Activity.RESULT_CANCELED) {
	    Toast.makeText(getActivity(), R.string.canceled_scan, Toast.LENGTH_SHORT).show
	  } else {
	    Toast.makeText(getActivity(), 
	        R.string.request_code_different, Toast.LENGTH_SHORT).show
	  }
  }
  
  override def onCreateView(inflater: LayoutInflater, 
      container: ViewGroup, savedInstanceState: Bundle): View = {
    workDetailsLayout =
      inflater.inflate(R.layout.fragment_work_details, null)
      
    workDetailsLayout.findViewById(R.id.scan_barcode).asInstanceOf[Button]
     
    val containerOption = 
      if (container == null) {
        None
      } else {
        Some(container)
      }
    
    containerOption.map(container => {
      val textView = new TextView(getActivity)
      textView.setText(getSentence)
      textView
    }) match {
      case Some(textView: TextView) => {
        textView
      }
      case None => {
        null
      }
    }
  }
}

object WorkOrderDetail {
  val LIST_INDEX_KEY = "list_index"
  val SENTENCE_KEY = "sentence_key"
    
  def apply(listIndex: Int, detailString: String): WorkOrderDetail = {
    val f = new WorkOrderDetail
    val args = new Bundle
    args.putInt(LIST_INDEX_KEY, listIndex)
    args.putString(SENTENCE_KEY, detailString)
    f.setArguments(args)
    f
  }
}