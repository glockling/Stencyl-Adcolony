package adcolony;

import com.jirbo.adcolony.*;

import android.app.*;
import android.content.pm.ActivityInfo;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;

import org.haxe.lime.HaxeObject;
import org.haxe.lime.GameActivity;
import org.haxe.extension.Extension;

import java.util.*;


public class AdColony implements AdColonyAdListener, AdColonyV4VCListener, AdColonyAdAvailabilityListener
{

    // Create Booleans to return
    public static boolean isAvailable = false;
    public static boolean wasShown = false;
    public static boolean wasClosed = false;
    
    //Create Keys
    public static String Store = "null";
    
    //Create Store "Zones"
   // public static String[] ZONES = null;
    
    //Load Ad Colony
    
    public static void Load(String app_id, String zone_ids, String appVersion, String storeVersion){
    
        if(Store == "null"){
        
        Store = ("version:"+ appVersion + ",store:" + storeVersion);
    
        }

        AdColony.configure(mainActivity, Store, app_id, zone_ids);
    }
    
    //Plays Regualar Ad
    public static void PlayAd(String zone_id){
    
        AdColonyVideoAd ad = new AdColonyVideoAd(zone_id);
        ad.show();
    
    }
    
    //Plays Rewarded Video
    public static void PlayV4VCAd(String zone_id, boolean prePopup, boolean postPopup){
    
        if(!prePopup && !postPopup){
        AdColonyV4VCAd ad = new AdColonyV4VCAd(zone_id);
        }
        else if(prePopup && !postPopup){
        AdColonyV4VCAd ad = new AdColonyV4VCAd(zone_id).withConfirmationDialog();
        }
        else if(!prePopup && postPopup){
        AdColonyV4VCAd ad = new AdColonyV4VCAd(zone_id).withResultsDialog();
        }
        else if(prePopup && postPopup){
        AdColonyV4VCAd ad = new AdColonyV4VCAd(zone_id).withResultsDialog().withConfirmationDialog();
        }
        
        ad.show();
    }
    
    
    //Sets Available Status for Return
    static public boolean Available(){
    
        if(isAvailable){
        
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    //Sets Shown Status for Return
    static public boolean Shown(){
    
        if(wasShown){
            wasShown = false;
            return true;
        }
        return false;
    }
    
    //Sets Shown Status for Status
    static public boolean Status(){
    
        if(wasClosed){
            wasClosed = false;
            return true;
        }
        return false;
    }
    
    //Listeners
    
    //V4VC Listener
    AdColonyV4VCListener listener = new AdColonyV4VCListener()
    {
    public void onAdColonyV4VCReward(AdColonyV4VCReward reward)
    {
    //Just an example, see API Details page for more information.
    if(reward.success())
    {
    wasClosed = true;
    }
    }
    };
    
    AdColony.addV4VCListener(listener);

}