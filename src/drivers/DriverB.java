package drivers;

import exception.MyException;

public class DriverB extends Driver{
    protected String licenseType;
    protected  String licenseCategory;

    public DriverB (String fullName, int driverLicense, int drivingExperience) {
        super(fullName, driverLicense, drivingExperience);
    }

    public void setLicenseType(String licenseType, String licenseCategory ) throws MyException {

        if ( licenseType == null || licenseType.equals("") || licenseCategory == null || !licenseCategory.equals("Категория «B»"))
            throw new MyException("Необходимо указать тип прав!  ");
        else { this.licenseType = licenseType; this.licenseCategory = licenseCategory; }
    }
}

