
/**
 * Copyright (c) 2012 Ephraim Tekle genzeb@gmail.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the 
 * following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 *  @author Ephraim A. Tekle
 *
 */

package connectivity;

import com.tekle.oss.android.connectivity.NetworkConnectivity;
import com.tekle.oss.android.connectivity.NetworkMonitorListener;
import com.tekle.oss.android.connectivity.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ConnectivityActivity extends Activity implements NetworkMonitorListener {
	
	TextView networkTextView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        networkTextView = (TextView)this.findViewById(R.id.networkTextView);
        
        NetworkConnectivity.sharedNetworkConnectivity().configure(this);
        NetworkConnectivity.sharedNetworkConnectivity().addNetworkMonitorListener(this);
        NetworkConnectivity.sharedNetworkConnectivity().startNetworkMonitor();
    }

	@Override
	public void connectionCheckInProgress() {
		networkTextView.setText("Checking connection");
	}

	@Override
	public void connectionEstablished() {
		networkTextView.setText("Connected");		
	}

	@Override
	public void connectionLost() {
		networkTextView.setText("No connection");
	}
}