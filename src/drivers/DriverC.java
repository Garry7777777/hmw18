package drivers;

import exception.MyException;

public class DriverC extends Driver{
    protected String licenseType;
    protected  String licenseCategory;
    public DriverC(String fullName, int driverLicense, int drivingExperience) {
        super(fullName, driverLicense, drivingExperience);
    }

    public void setLicenseType(String licenseType, String licenseCategory ) throws MyException {

        if ( licenseType == null || licenseType.equals("") || licenseCategory == null || !licenseCategory.equals("Категория «C»"))
            throw new MyException("Необходимо указать тип прав!  ");
        else { this.licenseType = licenseType; this.licenseCategory = licenseCategory; }
   }

}
