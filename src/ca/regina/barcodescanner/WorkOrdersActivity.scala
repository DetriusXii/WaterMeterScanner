package ca.regina.barcodescanner

import android.app.ListActivity
import android.os.Bundle
import android.widget._

class WorkOrdersActivity extends ListActivity {
	val names = Array("Andrew", "Bob", "Tiamat", "Bahamut")
  
	protected override def onCreate(savedInstanceState: Bundle): Unit = {
	  super.onCreate(savedInstanceState)
	  this.setContentView(R.layout.activity_work_orders)
	  
	  val listView = this.getListView()
	  val arrayAdapter = new ArrayAdapter[String](this, 
	      android.R.layout.simple_list_item_1, names)
	  listView.setAdapter(arrayAdapter)
	  
	}
}