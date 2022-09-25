
public class Main extends Base{
    public Main(){
        super("https://www.kupujemprodajem.com/index.php");
    }
    public static void main(String[] args) throws InterruptedException {
        Main test = new Main();
        test.closeRegistrationModal("kpBoxCloseButton");
        ///html/body/div[2]/div/div[1]/div[2]/div[4]
        test.selectLink("//*[@id=\"cookieConsentHolder\"]/div/div/div[2]/input");
        test.findLink(links("html/body/div[2]/div/div[1]/div[2]/div[4]/a"),"https://www.kupujemprodajem.com/bicikli/kategorija/912").click();
        test.printCategoryTitles();
        test.scrollAndSelectLink("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span");
        Thread.sleep(5000);
        test.closeDriver();
    }
}
