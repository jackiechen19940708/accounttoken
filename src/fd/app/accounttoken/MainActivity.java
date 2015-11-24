package fd.app.accounttoken;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import fd.app.myview.RoundProgressBar;

public class MainActivity extends Activity {
    private RoundProgressBar roundProgressBar=null;
    private Button start=null;
    int  i=0;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        roundProgressBar= (RoundProgressBar) findViewById(R.id.roundProgressBar2);
        start= (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new myAsyncTask().execute();

            }
        });
    }

    class myAsyncTask extends AsyncTask<Void,Integer,Boolean>{
        int i=0;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            roundProgressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            roundProgressBar.setProgress(values[0].intValue());
            if(i>10){
                roundProgressBar.setCricleColor(Color.RED);
            }
        }

        @Override
        protected Boolean doInBackground(Void... params) {
          try{
              while (true){
                  i=(i+1)%100;
                  try {
                      Thread.sleep(200);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  publishProgress(i);
              }
          }catch (Exception e){

          }

            return true;
        }
    }

}
