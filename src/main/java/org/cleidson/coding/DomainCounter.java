package org.cleidson.coding;/*
    Domain Counter

    You are in charge of a display advertising program. Your ads are displayed on websites all over the internet.
    You have some input data that counts how many times that users have clicked on an ad on each individual domain.
    Every line consists of a click count and a domain name, like this:

    counts = \[ "900,google.com",
        "60,mail.yahoo.com",
        "10,mobile.sports.yahoo.com",
        "40,sports.yahoo.com",
        "300,yahoo.com",
        "10,stackoverflow.com",
        "20,overflow.com",
        "5,com.com",
        "2,en.wikipedia.org",
        "1,m.wikipedia.org",
        "1,mobile.sports",
        "1,google.co.uk"\]

    Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND
    each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com".
    (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains.)

    Sample output (in any order/format):
    calculateClicksByDomain(counts) =>
        com:                     1345
        google.com:              900
        stackoverflow.com:       10
        overflow.com:            20
        yahoo.com:               410
        mail.yahoo.com:          60
        mobile.sports.yahoo.com: 10
        sports.yahoo.com:        50
        com.com:                 5
        org:                     3
        wikipedia.org:           3
        en.wikipedia.org:        2
        m.wikipedia.org:         1
        mobile.sports:           1
        sports:                  1
        uk:                      1
        co.uk:                   1
        google.co.uk:            1

    Sample of input
    String[] counts = {
        "900,google.com",
        "60,mail.yahoo.com",
        "10,mobile.sports.yahoo.com",
        "40,sports.yahoo.com",
        "300,yahoo.com",
        "10,stackoverflow.com",
        "20,overflow.com",
        "5,com.com",
        "2,en.wikipedia.org",
        "1,m.wikipedia.org",
        "1,mobile.sports",
        "1,google.co.uk"
    };
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainCounter {

    private static final Map<String, Long> domainMap = new HashMap<>();

    private static void splitDomain(String[] counts) {
        String[] stringArray;
        String domain;
        long count;
        for(String item : counts) {
            stringArray = item.split(",");
            domain = stringArray[1];
            count = Long.parseLong(stringArray[0]);

            processDomains(domain, count);
        }
    }

    /**
     * <p>
     * Split every subdomain and count number of visualization.
     * Increment the subdomain with previous one before count visualization.
     * </p>
     * <p>
     * E.g.: Receive google.com
     * <ul>
     * <li>Step 1: Split domain "google.com" into subdomains "com" and "google".</li>
     * <li>Step 2: Get first subdomain (com) and count total of visualization number.</li>
     * <li>Step 3: Get second subdomain (google), concat with previous subdomain and count total of visualization number.</li>
     * </ul>
     * </p>
     * @param domain {@link String} complete domain
     * @param count long number of total visualization
     */
    private static void processDomains(String domain, long count) {
        String[] subdomain =  domain.split("\\.");
        String before = "";

        for(int x=subdomain.length-1; x>=0; x--) {
            if(before.isEmpty())
                before = subdomain[x];
            else
                before = subdomain[x] + "." + before;

            fillDomainMap(before, count);
        }
    }

    private static void fillDomainMap(String domain, long count) {
        Long countAux = domainMap.get(domain);

        if(countAux == null)
            countAux = 0L;

        domainMap.put(domain, countAux + count);
    }

    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        splitDomain(counts);
        System.out.println(domainMap);
        validateDomainMapResult();
    }

    // Utils #############################################

    private static void validateDomainMapResult() {
        List<String> valuesExpected = new ArrayList<>();
        valuesExpected.add("com=1345");
        valuesExpected.add("google.com=900");
        valuesExpected.add("stackoverflow.com=10");
        valuesExpected.add("overflow.com=20");
        valuesExpected.add("yahoo.com=410");
        valuesExpected.add("mail.yahoo.com=60");
        valuesExpected.add("mobile.sports.yahoo.com=10");
        valuesExpected.add("sports.yahoo.com=50");
        valuesExpected.add("com.com=5");
        valuesExpected.add("org=3");
        valuesExpected.add("wikipedia.org=3");
        valuesExpected.add("en.wikipedia.org=2");
        valuesExpected.add("m.wikipedia.org=1");
        valuesExpected.add("mobile.sports=1");
        valuesExpected.add("sports=1");
        valuesExpected.add("uk=1");
        valuesExpected.add("co.uk=1");
        valuesExpected.add("google.co.uk=1");
        
        String result = "";
        for(Map.Entry<String, Long> entry : domainMap.entrySet()) {
            result = entry.getKey() + "=" + entry.getValue();

            if(valuesExpected.contains(result)) {
                System.out.println(result + ": ok");
            } else {
                System.out.println(result + ": not ok");
            }
        }
    }
}