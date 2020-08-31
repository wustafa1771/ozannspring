package sample.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import sample.service.entities.ConversationRequest;
import sample.service.entities.ConversationResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("welcomeService")
public class OzanServiceImpl implements OzanService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${currency.api.base.uri}")
    private String currencyApiUrl;

    @Autowired
    Conversationepository conversationepository;
    @Autowired
     EntityManager entityManager;


    private final String exampleResponse = "{\"success\":true,\"timestamp\":1598705946,\"base\":\"EUR\",\"date\":\"2020-08-29\",\"rates\":{\"AED\":4.373501,\"AFN\":91.680393,\"ALL\":124.076567,\"AMD\":580.132771,\"ANG\":2.137376,\"AOA\":710.465576,\"ARS\":88.011898,\"AUD\":1.616194,\"AWG\":2.14317,\"AZN\":2.028832,\"BAM\":1.956249,\"BBD\":2.384731,\"BDT\":101.010874,\"BGN\":1.956869,\"BHD\":0.4488,\"BIF\":2297.912052,\"BMD\":1.19065,\"BND\":1.61976,\"BOB\":8.216128,\"BRL\":6.41933,\"BSD\":1.190765,\"BTC\":0.000104,\"BTN\":87.283121,\"BWP\":13.655339,\"BYN\":3.179381,\"BYR\":23336.739386,\"BZD\":2.387431,\"CAD\":1.559555,\"CDF\":2321.76787,\"CHF\":1.076557,\"CLF\":0.033636,\"CLP\":928.116309,\"CNY\":8.174293,\"COP\":4459.579458,\"CRC\":708.917766,\"CUC\":1.19065,\"CUP\":31.552224,\"CVE\":110.288621,\"CZK\":26.114574,\"DJF\":211.602781,\"DKK\":7.443115,\"DOP\":69.551477,\"DZD\":152.364,\"EGP\":18.892999,\"ERN\":17.860176,\"ETB\":43.040616,\"EUR\":1,\"FJD\":2.524778,\"FKP\":0.891771,\"GBP\":0.891802,\"GEL\":3.679574,\"GGP\":0.891771,\"GHS\":6.888375,\"GIP\":0.891771,\"GMD\":61.680256,\"GNF\":11501.263208,\"GTQ\":9.180644,\"GYD\":248.965397,\"HKD\":9.227912,\"HNL\":29.364535,\"HRK\":7.541105,\"HTG\":133.375681,\"HUF\":354.105301,\"IDR\":17305.7401,\"ILS\":4.002375,\"IMP\":0.891771,\"INR\":87.070451,\"IQD\":1421.526285,\"IRR\":50132.317351,\"ISK\":163.738643,\"JEP\":0.891771,\"JMD\":178.141644,\"JOD\":0.844218,\"JPY\":125.452881,\"KES\":128.749994,\"KGS\":93.428284,\"KHR\":4916.994199,\"KMF\":491.679362,\"KPW\":1071.584972,\"KRW\":1405.693716,\"KWD\":0.363708,\"KYD\":0.992321,\"KZT\":500.517183,\"LAK\":10885.022075,\"LBP\":1800.600664,\"LKR\":221.835759,\"LRD\":237.301033,\"LSL\":20.658231,\"LTL\":3.51568,\"LVL\":0.720213,\"LYD\":1.627348,\"MAD\":10.907035,\"MDL\":19.843749,\"MGA\":4584.331718,\"MKD\":61.628198,\"MMK\":1597.384575,\"MNT\":3401.373246,\"MOP\":9.505315,\"MRO\":425.062217,\"MUR\":47.319998,\"MVR\":18.348367,\"MWK\":892.176053,\"MXN\":25.900928,\"MYR\":4.959657,\"MZN\":85.203361,\"NAD\":20.658226,\"NGN\":461.329686,\"NIO\":41.509237,\"NOK\":10.532883,\"NPR\":139.653074,\"NZD\":1.765626,\"OMR\":0.45836,\"PAB\":1.190765,\"PEN\":4.243844,\"PGK\":4.152624,\"PHP\":57.583999,\"PKR\":199.312853,\"PLN\":4.388605,\"PYG\":8301.847434,\"QAR\":4.335202,\"RON\":4.840116,\"RSD\":117.612849,\"RUB\":88.209546,\"RWF\":1151.326491,\"SAR\":4.4655,\"SBD\":9.841399,\"SCR\":21.297999,\"SDG\":65.847323,\"SEK\":10.285156,\"SGD\":1.617641,\"SHP\":0.891771,\"SLL\":11623.724688,\"SOS\":693.557973,\"SRD\":8.879913,\"STD\":25352.23245,\"SVC\":10.419319,\"SYP\":609.176759,\"SZL\":19.911031,\"THB\":37.038784,\"TJS\":12.285431,\"TMT\":4.179181,\"TND\":3.247502,\"TOP\":2.710694,\"TRY\":8.733303,\"TTD\":8.069996,\"TWD\":34.94324,\"TZS\":2762.524671,\"UAH\":32.727308,\"UGX\":4377.237325,\"USD\":1.19065,\"UYU\":50.95834,\"UZS\":12230.929226,\"VEF\":11.891621,\"VND\":27593.313024,\"VUV\":133.422671,\"WST\":3.1507,\"XAF\":656.10301,\"XAG\":0.043274,\"XAU\":0.000606,\"XCD\":3.217792,\"XDR\":0.843188,\"XOF\":656.097498,\"XPF\":120.140868,\"YER\":298.079653,\"ZAR\":19.732464,\"ZMK\":10717.282776,\"ZMW\":23.249079,\"ZWL\":383.389419}}";

    public double convertCurrency(String target, String source) {
        System.out.println("in srevice");
    /*   String url = currencyApiUrl+apiKey;
       RestTemplate restTemplate= new  RestTemplate();
       restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
       String result = restTemplate.getForObject(url,String.class);*/
        JSONObject jsonObject = new JSONObject(exampleResponse);
        JSONObject rates = jsonObject.getJSONObject("rates");
        double sourceRate = rates.getDouble(source);
        double targetRate = rates.getDouble(target);

        return sourceRate / targetRate;
    }

    @Override
    public ConversationResponse conversion(ConversationRequest conversationRequest) {
        double exchangeRate = convertCurrency(conversationRequest.getSource(), conversationRequest.getTarget());
        ConversationResponse conversationResponse = new ConversationResponse(conversationRequest);
        conversationResponse.setTargetAmount(conversationRequest.getAmount() * exchangeRate);

        ConversationResponse conversationResponsereturn = conversationepository.save(conversationResponse);
        return conversationResponsereturn;
    }

    @Override
    public List<ConversationResponse> getConversionList(ConversationRequest conversationRequest) {
        ConversationResponse conversationResponse = new ConversationResponse(conversationRequest);
        List<ConversationResponse> i = conversationepository.findAll();
        return getConversionListByCondition(conversationRequest);
    }
    //TODO creata data layer and move these on it
    public List<ConversationResponse> getConversionListByCondition(ConversationRequest conversationRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<ConversationResponse> cq = cb.createQuery(ConversationResponse.class);

        Root<ConversationResponse> conversationResponseRoot = cq.from(ConversationResponse.class);
        Predicate authorNamePredicate = cb.equal(conversationResponseRoot.get("source"),conversationRequest.getSource());
        Predicate titlePredicate = cb.like(conversationResponseRoot.get("target"),conversationRequest.getTarget() );
        cq.where(authorNamePredicate, titlePredicate);

        TypedQuery<ConversationResponse> query = entityManager.createQuery(cq);
        return query.getResultList();

    }


}

