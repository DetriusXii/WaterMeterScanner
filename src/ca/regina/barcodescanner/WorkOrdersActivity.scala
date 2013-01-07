package ca.regina.barcodescanner

import android.app._
import android.os.Bundle
import android.widget._
import android.view.View
import android.content._

object WorkOrdersActivity {
  val SCAN_INTENT = "com.google.zxing.client.android.SCAN"
  val PACKAGE_NAME = "com.google.zxing.client.android"
  val SCAN_MODE = "SCAN_MODE"
  val QR_CODE_MODE = "QR_CODE_MODE"
  val SCAN_RESULT = "SCAN_RESULT"
  val SCAN_RESULT_FORMAT = "SCAN_RESULT_FORMAT"
}

class WorkOrdersActivity extends Activity {
	
	protected override def onCreate(savedInstanceState: Bundle): Unit = {
	  super.onCreate(savedInstanceState)
	  setContentView(R.layout.activity_work_orders2)
	}
	/*
	protected override def onCreate(savedInstanceState: Bundle): Unit = {
	  super.onCreate(savedInstanceState)
	  this.setContentView(R.layout.activity_work_orders)
	  
	  val listView = this.getListView()
	  val arrayAdapter = new ArrayAdapter[String](this, 
	      android.R.layout.simple_list_item_1, names)
	  listView.setAdapter(arrayAdapter)
	  
	}
	
	protected override def onListItemClick(lv: ListView, 
	    v: View, position: Int, id: Long): Unit = {
	  val intent = new Intent(WorkOrdersActivity.SCAN_INTENT)
	  intent.setPackage(WorkOrdersActivity.PACKAGE_NAME)
	  intent.putExtra(WorkOrdersActivity.SCAN_MODE, 
	      WorkOrdersActivity.QR_CODE_MODE)
	  
	  try {
	    this.startActivityForResult(intent, 0)
	  } catch {
	    case _: ActivityNotFoundException => 
	      Toast.makeText(this, 
	          R.string.no_zxing_scanner, 
	          Toast.LENGTH_SHORT).show
	  }
	}
	
	override def onActivityResult(requestCode: Int,
	    resultCode: Int, intent: Intent): Unit = {
	  if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
	    val contents = 
	      intent.getStringExtra(WorkOrdersActivity.SCAN_RESULT)
	    val format = 
	      intent.getStringExtra(WorkOrdersActivity.SCAN_RESULT_FORMAT)
	    
	    Toast.makeText(this, contents, Toast.LENGTH_LONG).show
	  } else if (requestCode == 0 && resultCode == Activity.RESULT_CANCELED) {
	    Toast.makeText(this, R.string.canceled_scan, Toast.LENGTH_SHORT).show
	  } else {
	    Toast.makeText(this, 
	        R.string.request_code_different, Toast.LENGTH_SHORT).show
	  }
	}*/
}

