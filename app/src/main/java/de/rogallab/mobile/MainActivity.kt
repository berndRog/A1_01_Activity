package de.rogallab.mobile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
class MainActivity : AppCompatActivity() {
   // local variables are deleted during a state change !!!
   // (e.g. rotating the device)
   private var _name:String = ""
   private var _email:String = ""

   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      // render screen
      setContentView(R.layout.activity_main)

      if (savedInstanceState != null) {
         Log.d(TAG, "onCreate() Bundle != null")
         getStateFromBundle(savedInstanceState)
      }

      // button event handler
      findViewById<Button>(R.id.main_bt_send).setOnClickListener {
         Log.i(TAG,"main_bt_send.OnClick()")
         getStateFromUiElements()
      }
   }

   private fun getStateFromUiElements() {
      _name  = findViewById<EditText>(R.id.main_et_name).text.toString()
      _email = findViewById<EditText>(R.id.main_et_email).text.toString()
      Log.d(TAG, "getStateFromUiElements()\nName: $_name Email:$_email")
   }
   private fun setUiElementsFromState() {
      Log.d(TAG, "setUiElementsFromState()\nName: $_name Email:$_email")

      findViewById<EditText>(R.id.main_et_name).setText(_name)
      findViewById<EditText>(R.id.main_et_email).setText(_email)
   }

   private fun putStateToBundle(bundle: Bundle) {
      //                key    value
      bundle.putString (NAME,  _name)
      bundle.putString (EMAIL, _email)
      Log.d(TAG, "putStateToBundle()\nName: $_name Email:$_email")
   }

   private fun getStateFromBundle(savedInstanceState: Bundle) {
      _name = savedInstanceState.getString(NAME) ?: ""
      _email = savedInstanceState.getString(EMAIL) ?: ""
      Log.d(TAG, "getStateFromBundle()\nName: $_name Email:$_email")
      setUiElementsFromState()
   }

   // Activity is restarted
   override fun onRestart() {
      super.onRestart()
      Log.d(TAG, "onRestart()")
   }

   // Activity is visible
   override fun onStart() {
      super.onStart()
      Log.d(TAG, "onStart()")
   }

   // Activity interacts with the user
   override fun onResume() {
      super.onResume()
      Log.d(TAG, "onResume()")
   }

   // User is leaving activity
   override fun onPause() {
      Log.d(TAG, "onPause()")
      super.onPause()
   }

   // Activity is no longer visible
   override fun onStop() {
      Log.d(TAG, "onStop()")
      super.onStop()
   }

   // Called before the activity is destroyed
   override fun onDestroy() {
      Log.d(TAG, "onDestroy()")
      super.onDestroy()
   }

   // override save/restore state methods -------------------------------------
   // Save instance state: invoked when the activity may be temporarily destroyed,
   override fun onSaveInstanceState(savedStateBundle: Bundle) {
      super.onSaveInstanceState(savedStateBundle)
      Log.d(TAG, "onSaveInstanceState()")
      getStateFromUiElements()
      putStateToBundle(savedStateBundle)
   }

   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
      super.onRestoreInstanceState(savedInstanceState)
      Log.d(TAG, "onRestoreInstanceState()")
      getStateFromBundle(savedInstanceState)
      setUiElementsFromState()
   }

   override fun onWindowFocusChanged(hasFocus: Boolean) {
      Log.d(TAG, "onWindowFocusChanged() $hasFocus")
      super.onWindowFocusChanged(hasFocus)
   }

   companion object {        //12345678901234567890123
      private const val TAG = "ok>MainActivity       ."
      private const val NAME  = "MainActivityName"
      private const val EMAIL = "MainActivityEmail"
   }
}