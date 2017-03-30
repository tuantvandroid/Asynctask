package com.synchronous.thispc.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
/**
 * Created by This PC on 3/30/2017.
 */

public class AsynctaskNetwork extends AsyncTask<String , Void , String> {
    ProgressDialog progressDialog;
    Context context;
    TextView textView;
    public AsynctaskNetwork(Context context, TextView textView)
    {
        this.context = context;
        this.textView = textView;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download");
        progressDialog.setMessage("Đang xử lý . . .!");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try
        {
            StringBuilder sb;
            // Website này sẽ cho biết địa chỉ IP của bạn.
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                Log.e("Nội dung ", sb.toString());
                br.close();
                return sb.toString();
            }

        }
        catch (IOException  ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String aString) {
        super.onPostExecute(aString);
        progressDialog.dismiss();
        textView.setText(aString);
    }
}
