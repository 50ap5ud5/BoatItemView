package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BUkranianLangGen extends BEnglishLangGen {

    public BUkranianLangGen(PackOutput out) {
        super(out, "uk_ua");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Показувати предмети в рухомому човні");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Відображувані предмети в рухомому човні");
        //Config Name for Cloth Config mod used in the Fabric version and Config type (Client/Common/Server) in Neoforge
        this.addConfigTitleTranslation("Boat Item View");
        //Neoforge Config translations
        this.add(BTranslationKeys.CLIENT_CONFIG_TITLE, "Клієнт Boat Item View");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION, "Налаштування клієнта");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION_TITLE, "Налаштування клієнта");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_SHOW_HANDS), "Перемикає відображення предмета в руці під час руху човна");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_WHITELIST_ITEMS), "Предмети, які залишатимуться відображатися в руці. Додавання символу «*» після ідентифікатора мода включатиме всі предмети з мода. Наприклад, «modid:*». Якщо ідентифікатор мода не вказано перед символом «*», будуть включені всі предмети. Наприклад, «*»");
	}
}
