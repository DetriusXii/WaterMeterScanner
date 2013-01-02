package ca.regina.barcodescanner

import android.os.Bundle
import android.widget._
import android.view.View
import android.content.Intent

class MainActivity extends android.app.Activity {
	protected override def onCreate(savedInstanceState: Bundle): Unit = {
	  super.onCreate(savedInstanceState)
	  this.setContentView(R.layout.activity_main)
	  
	  val viewWorkOrdersButton =
	    this.findViewById(R.id.view_work_orders_button).asInstanceOf[Button]
	  viewWorkOrdersButton.setOnClickListener(new View.OnClickListener {
	    def onClick(view: View): Unit = {
	      val intent = 
	        new Intent(MainActivity.this, classOf[WorkOrdersActivity])
	      MainActivity.this.startActivity(intent)
	      
	    }
	  })
	}
}