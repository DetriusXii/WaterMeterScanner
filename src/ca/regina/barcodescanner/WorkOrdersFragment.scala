package ca.regina.barcodescanner
import android.os.Bundle
import android.widget._
import android.view._
import android.app._

class WorkOrdersFragment extends ListFragment {
	val names = Array("Andrew", "Bob", "Tiamat", "Bahamut")
	val sentences = Array("This is Sparta", "Hello world", "The dark queen", "The dragon king")
	
	private var selectedIndex: Int = 0
	
	override def onActivityCreated(savedInstanceState: Bundle): Unit = {
	  super.onActivityCreated(savedInstanceState)
	  
	  setListAdapter(new ArrayAdapter[String](getActivity, 
	      android.R.layout.simple_list_item_1,
	      names))
	}
	
	override def onListItemClick(lv: ListView, v: View, position: Int, id: Long): Unit = {
	  showDetails(position)
	}
	
	private def showDetails(index: Int): Unit = {
	  selectedIndex = index;
	  
	  val workOrderDetail = 
	    getFragmentManager.findFragmentById(R.id.details).asInstanceOf[WorkOrderDetail]
	  val workOrderDetailOption = 
	    if (workOrderDetail == null || workOrderDetail.getShownIndex != index) { 
	      Some(Unit) 
	    } else {
	      None
	    }
	  workOrderDetailOption.map(_ => {
	    val newWorkOrderDetail = WorkOrderDetail(index, sentences(index))
	    val ft = getFragmentManager.beginTransaction
	    ft.replace(R.id.details, newWorkOrderDetail)
	    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
	    ft.commit
	  })
	  
	}
}