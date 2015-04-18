package AdColony;

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

public class AdColony extends Extension implements AdColonyAdListener, AdColonyV4VCListener, AdColonyAdAvailabilityListener
{

    public static void configure(String appid, String zoneid, String store, String version){
        
        AdColony.configure( mainActivity,"version:" + version + ",store:" + store,appid,zoneid);
    
    
    }


}