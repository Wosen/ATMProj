package atmPackage;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SAatm extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;	
    private int pinNbr;
	private int blcAmt;
	private int wtdrwAmt;
    private int dpstAmt;
    
    private int loggedPin = 0;
    private int loggedBlnc;
    
    DBatm dbAtm  = new DBatm();

	public void setWtdrwAmt(int wtdrwAmt) {
		this.wtdrwAmt = wtdrwAmt;
	}

	public int getWtdrwAmt() {
		return wtdrwAmt;
	}
	
	public void setDpstAmt(int dpstAmt) {
		this.dpstAmt = dpstAmt;
	}	

	public int getDpstAmt() {
		return dpstAmt;
	}
	
	public void setBlcAmt(int blcAmt) {
		this.blcAmt = blcAmt;
	}	
	
	public int getBlcAmt() {
		return blcAmt;
	}
 
    public void setPinNbr(int pinNbr) {
        this.pinNbr = pinNbr;
    }    
    
    public int getPinNbr() {
		return pinNbr;
	}
    
    public String accntBal(){
    	String balString = dbAtm.readblnc(pinNbr);
    	
    	if(balString == null){
    		addActionError("Invalid PIN! Please try again.");
    		return "error";
    	}else{    		
    		int balInt = Integer.parseInt(balString);
    		setBlcAmt(balInt);   
    		
    		sessionMap.put("pinNbr", pinNbr);
    		sessionMap.put("blcAmt", blcAmt);
    		
    		return "accnt";
    	}
    }
    
    public String wthdrwCash(){    
    	loggedPin = (int) sessionMap.get("pinNbr");
    	loggedBlnc = (int) sessionMap.get("blcAmt");
    	
    	if(wtdrwAmt == loggedBlnc || wtdrwAmt < loggedBlnc){
    		blcAmt = loggedBlnc - wtdrwAmt;
    		dbAtm.updateBlnc(loggedPin, blcAmt);
    		setBlcAmt(blcAmt);
    		sessionMap.replace("blcAmt", blcAmt);
    		return "scs";
    	}else{
    		addActionError("You don't have sufficient amount");
    		return "accnt";
    	}    	
    }
    
    public String dpstCash(){
    	loggedPin = (int) sessionMap.get("pinNbr");
    	loggedBlnc = (int) sessionMap.get("blcAmt");
    	if(dpstAmt > 0){
    		blcAmt = loggedBlnc + dpstAmt;
    		dbAtm.updateBlnc(loggedPin, blcAmt);
    		setBlcAmt(blcAmt);
    		sessionMap.replace("blcAmt", blcAmt);
    		return "scs";
    	}else{
    		addActionError("Please try again!");
    		return "accnt";    		
    	}    	
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}