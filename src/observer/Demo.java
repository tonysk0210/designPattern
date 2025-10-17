package observer;

public class Demo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel sportsChannel = new NewsChannel("Sports Channel");
        NewsChannel financeChannel = new NewsChannel("Finance Channel");
        NewsChannel techChannel = new NewsChannel("Tech Channel");

        agency.registerObserver(sportsChannel);
        agency.registerObserver(financeChannel);
        agency.registerObserver(techChannel);

        agency.publishNews("Local team wins the championship!");
        System.out.println(sportsChannel.getName() + " latest headline: " + sportsChannel.getLatestHeadline());

        agency.publishNews("Stocks rally after positive earnings.");
        System.out.println(financeChannel.getName() + " latest headline: " + financeChannel.getLatestHeadline());

        agency.removeObserver(financeChannel);
        agency.publishNews("New smartphone model breaks sales records.");

        System.out.println(financeChannel.getName() + " still tracking: " + financeChannel.getLatestHeadline());
    }
}
