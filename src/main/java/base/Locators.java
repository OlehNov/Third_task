package base;

public class Locators {
    public static  final String SERIOUS = ".md-select-menu-container.md-active.md-clickable md-option[value^='%s']";
    public static  final String MACHINE = "//md-option[@value='%s']";
    public static  final String VIDEO_CARD = "div[role='presentation'][aria-hidden='false'] ._md>md-option[value^='%s']";
    public static  final String GPU = "div[aria-hidden='false'][role='presentation'] md-option[value^='%s']";
    public static  final String SSD = "md-option[ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][value='%s']";
    public static  final String LOCATION = "div[role^='presentation'] ._md.md-overflow ._md>md-optgroup>md-option[value^='%s']";
    public static  final String YEARS = "div[role='presentation'][aria-hidden='false'] md-option[ng-value^='%s']";
    public static  final String FIRST_CALCULATE_IFRAME = "iframe[src*='frame/products/calculator/index']";
    public static  final String SECOND_CALCULATE_IFRAME = "myFrame";
    public static  final String YOPMAIL_IFRAME = "iframe[name^='ifmail']";

}
