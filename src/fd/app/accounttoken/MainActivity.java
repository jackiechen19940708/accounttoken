package fd.app.accounttoken;

import android.app.Activity;
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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        i=(i+1)%100;
                        roundProgressBar.setProgress(i);
                    }
                }).start();
                            }
        });
    }
}
