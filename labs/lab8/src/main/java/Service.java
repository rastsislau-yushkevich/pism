import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class Service {
    String aString;
    String bString;
    String cString;
    String resString;

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public String getbString() {
        return bString;
    }

    public void setbString(String bString) {
        this.bString = bString;
    }

    public String getcString() {
        return cString;
    }

    public void setcString(String cString) {
        this.cString = cString;
    }

    public String getResString() {
        return resString;
    }

    public void setResString(String resString) {
        this.resString = resString;
    }

    public String doTask() {
//        StringBuilder str = new StringBuilder();
//
//        for (int i = 0; i < string.length(); i++) {
//            if (Character.isUpperCase(string.charAt(i))) {
//                amount++;
//            }
//        }
//
//        string = str.toString();

        resString = String.valueOf(((Integer.parseInt(aString)+Integer.parseInt(bString))*Integer.parseInt(cString)));

        return "response";
    }

    public void validateRequired(FacesContext context, UIComponent comp, Object value) {

        System.out.println("inside validate method");

        String string = (String) value;

        if (string.length() < 1) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("This field is required");
            context.addMessage(comp.getClientId(context), message);

        }
    }
}

