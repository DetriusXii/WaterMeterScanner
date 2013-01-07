package ca.regina.barcodescanner

import android.app.Fragment
import android.os.Bundle
import android.view._
import android.widget._

class WorkOrderDetail extends Fragment {

  def getShownIndex: Int = getArguments.getInt(WorkOrderDetail.LIST_INDEX_KEY)
  def getSentence: String = getArguments.getString(WorkOrderDetail.SENTENCE_KEY)
  
  override def onCreateView(inflater: LayoutInflater, 
      container: ViewGroup, savedInstanceState: Bundle): View = {
    val containerOption = if (container == null) {None} else {Some(container)}
    
    containerOption.map(container => {
      val textView = new TextView(getActivity)
      textView.setText(getSentence)
      
      textView
    }) match {
      case textView: TextView => textView
      case _ => return null
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
    
    return f
  }
}