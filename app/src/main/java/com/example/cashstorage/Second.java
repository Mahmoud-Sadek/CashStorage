package com.example.cashstorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends Activity {

	Button Internal_Cach_btn;
	Button External_Cach_btn;
	Button External_Private_btn;
	Button External_Public_btn;
	Button Next_btn;
	EditText User_Name;
	TextView status;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		  Internal_Cach_btn=(Button)findViewById(R.id.Internal_Cache_Btn);
	        External_Cach_btn=(Button)findViewById(R.id.External_Cache_Btn);
	        External_Private_btn=(Button)findViewById(R.id.External_Private_Btn);
	        External_Public_btn=(Button)findViewById(R.id.External_Public_Btn);
	        Next_btn=(Button)findViewById(R.id.Next_Btn);
	        User_Name=(EditText)findViewById(R.id.User_Name_Txt);
	        status=(TextView)findViewById(R.id.textView1);

	        Internal_Cach_btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					File Folder= getCacheDir();
					File MyFile=new File(Folder,"Internal.txt");
					String Text=Read_Data( MyFile);
					if(Text!=null){
			User_Name.setText(Text);;
			Toast.makeText(getBaseContext(), " Done "+ MyFile.getAbsolutePath()+"//Internal.txt", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(getBaseContext(), " Falid ", Toast.LENGTH_LONG).show();
					}
				}
			});
	        
	           External_Cach_btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					File Folder= getExternalCacheDir();
					File MyFile=new File(Folder,"External.txt");
					String Text=Read_Data( MyFile);
					if(Text!=null){
			User_Name.setText(Text);;
			Toast.makeText(getBaseContext(), " Done "+ MyFile.getAbsolutePath()+"//Internal.txt", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(getBaseContext(), " Falid ", Toast.LENGTH_LONG).show();
					}
				}
			});
	           External_Private_btn.setOnClickListener(new OnClickListener() {
	   			
	   			@Override
	   			public void onClick(View arg0) {
	   				// TODO Auto-generated method stub
	   				File Folder= getExternalFilesDir("Slinder");
					File MyFile=new File(Folder,"External_private.txt");
					String Text=Read_Data( MyFile);
					if(Text!=null){
			User_Name.setText(Text);;
			Toast.makeText(getBaseContext(), " Done "+ MyFile.getAbsolutePath()+"//Internal.txt", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(getBaseContext(), " Falid ", Toast.LENGTH_LONG).show();
					}
	   			}
	   		});
	           External_Public_btn.setOnClickListener(new OnClickListener() {
	   			
	   			@Override
	   			public void onClick(View arg0) {
	   				// TODO Auto-generated method stub
	   				File Folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
					File MyFile=new File(Folder,"External_public.txt");
					String Text=Read_Data( MyFile);
					if(Text!=null){
			User_Name.setText(Text);;
			Toast.makeText(getBaseContext(), " Done "+ MyFile.getAbsolutePath()+"//Internal.txt", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(getBaseContext(), " Falid ", Toast.LENGTH_LONG).show();
					}
	   			}
	   		});	        
	        
	        
	        Next_btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					Intent I1=new Intent(Second.this,MainActivity.class);
					startActivity(I1);
					finish();
				}
					
			});
	}
	public String Read_Data(File MyFile){
    	FileInputStream FIS=null;
    	try {
			FIS=new FileInputStream(MyFile);
			int read=-1;
			StringBuffer buffer=new StringBuffer();
			while ((read=FIS.read())!=-1) {
				buffer.append((char)read);
			}
			
			return buffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(FIS!=null){
				try {
					FIS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		}
    	return null;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
