package com.example.cashstorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PublicKey;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button Internal_Cach_btn;
	Button External_Cach_btn;
	Button External_Private_btn;
	Button External_Public_btn;
	Button Next_btn;
	EditText User_Name;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Internal_Cach_btn=(Button)findViewById(R.id.Internal_Cache_Btn);
        External_Cach_btn=(Button)findViewById(R.id.External_Cache_Btn);
        External_Private_btn=(Button)findViewById(R.id.External_Private_Btn);
        External_Public_btn=(Button)findViewById(R.id.External_Public_Btn);
        Next_btn=(Button)findViewById(R.id.Next_Btn);
        User_Name=(EditText)findViewById(R.id.User_Name_Txt);
        
        
        Internal_Cach_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File Folder= getCacheDir();
				File MyFile=new File(Folder,"Internal.txt");
				String text=User_Name.getText().toString();
				Write_Data(text, MyFile);
				}
		});
        
           External_Cach_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File Folder= getExternalCacheDir();
				File MyFile=new File(Folder,"External.txt");
				String text=User_Name.getText().toString();
				Write_Data(text, MyFile);
			}
		});
           External_Private_btn.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				File Folder= getExternalFilesDir("Slinder");
				File MyFile=new File(Folder,"External_private.txt");
				String text=User_Name.getText().toString();
				Write_Data(text, MyFile);
   				
   			}
   		});
           External_Public_btn.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				File Folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
				File MyFile=new File(Folder,"External_public.txt");
				String text=User_Name.getText().toString();
				Write_Data(text, MyFile);
   				
   			}
   		});
        
        
        Next_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent I1=new Intent(MainActivity.this,Second.class);
				startActivity(I1);
				finish();
			}
				
		});
    }

    public void Write_Data(String text,File MyFile){
    	FileOutputStream FOS=null;
    	try {
			FOS=new FileOutputStream(MyFile);
			FOS.write(text.getBytes());
			Toast.makeText(getBaseContext(), " Done "+ MyFile.getAbsolutePath()+"//Internal.txt", Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(FOS!=null){
				try {
					FOS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
