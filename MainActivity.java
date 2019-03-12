package fr.studio.cracky.switcher4g;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.net.Uri;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            Intent RadioInfo = new Intent("android.intent.action.MAIN");
            RadioInfo.setClassName("com.android.settings", "com.android.settings.RadioInfo");
            startActivity(RadioInfo);
            finish();
        }
        catch (Exception e)
        {
            Builder ErrorMessage = new Builder(this);
            ErrorMessage.setMessage("Sorry, your phone configuration rejects the functions used by this application. You can't use it.");
            ErrorMessage.setPositiveButton("I UNDERSTAND", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    dialog.dismiss();
                    Intent Uninstall = new Intent(Intent.ACTION_DELETE);
                    Uninstall.setData(Uri.parse("package:fr.studio.cracky.switcher4g"));
                    startActivity(Uninstall);
                    finish();
                }
            });
            ErrorMessage.show();
        }
    }
}