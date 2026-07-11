package com.company.automation.locators.features.transfer;

import com.company.automation.locators.Locator;
import com.company.automation.locators.LocatorFactory;

public class TransferLocator {
    private TransferLocator() {
    }

    public static final Locator TITLE_TRANSFER = new Locator("Halaman Transfer",
            LocatorFactory.flutterId("title_transfer_antar_bank"));

    public static final Locator INPUT_AMOUNT = new Locator("Input Amount",
            LocatorFactory.flutterId("input_nominal"));

    public static final Locator CHOOSE_BANK = new Locator("Choose Bank",
            LocatorFactory.flutterId("dropdown_bank"));

    public static final Locator CLICK_LANJUT_INPUT_AMOUNT = new Locator("Click Input Transfer",
            LocatorFactory.flutterId("btn_lanjutkan"));

    public static final Locator CLICK_LANJUT_INQUIRY = new Locator("Click Inquiry Transfer",
            LocatorFactory.flutterId("btn_lanjut_inquiry"));

    public static final Locator CLICK_LANJUT_CONFIRMATION = new Locator("Click Lanjut Konfirmasi",
            LocatorFactory.flutterId("btn_confirm_transfer"));

    public static final Locator CLICK_SUSCCESS_BACK_DASHBOARD = new Locator("Click Success Transfer",
            LocatorFactory.flutterId("btn_back_dashboard"));

    public static final Locator TITLE_INQURIY = new Locator("Halaman Inquiry Transfer",
            LocatorFactory.flutterId("title_inquiry_transfer"));

    public static final Locator TITLE_CONFIRMATION = new Locator("Halaman Konfirmasi Transfer",
            LocatorFactory.flutterId("title_confirm_transfer"));

    public static final Locator TITLE_SUCCESS = new Locator("Halaman Success Transfer",
            LocatorFactory.flutterId("lbl_transfer_success"));

    public static final Locator ERROR_TEXT = new Locator("Nominal dan Bank harus diisi",
            LocatorFactory.flutterId("txt_nominal_null"));
}
