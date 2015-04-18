package;


import openfl.Lib;

#if cpp
import cpp.Lib;
#end

class AdColony
{
    
    //Called from Blocks.xml this loads Ad Colony with a specific Zone ID
    public static function load(appid:String, zoneid:String, store:String, version:String):Void{
        
        #if ios
            if(store != "android" && store != "amazon"){
        LoadAd(appid, zoneid);
            }
        #end
        
        #if android
            if(store != "ios"){
            Configure(appid, zoneid, store, version);
            }
        #end
    
    }
    
    //Called from Blocks.xml this plays Ad Colony Ad with a specific Zone ID
    public static function play(zoneID:String):Void{
        
        #if ios
        PlayAd(zoneID);
        #end
        
    }
    
    //Called from Blocks.xml this checks if ad with zone id is loaded
    
    public static function available(zoneid:String):Bool{
        #if ios
        return Available(zoneid);
        #end
    }
    
    //Called from Blocks.xml this updates the status of zone ID "Closed"
    
    public static function status(zoneid:String):Bool{
        #if ios
        return Status(zoneid);
        #end
    }
    
    // Called from Blocks.xml this updates the status of Zone ID "Showing"
    
    public static function showing(zoneid:String):Bool{
        #if ios
        return Showing(zoneid);
        #end
    }
    
     
	#if ios
	private static var LoadAd = Lib.load("adcolony","init_adcolony", 2);
    private static var PlayAd = Lib.load("adcolony","play_adcolony", 1);
    private static var Available = Lib.load("adcolony","available_adcolony", 1);
    private static var Status = Lib.load("adcolony","status_adcolony", 1);
    private static var Showing = Lib.load("adcolony","showing_adcolony",1);
	#end
        
    if #android
    private static var Configure:String->String->String->String->Void = JNI.createStaticMethod("AdColony", "configure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        
    #end
}
