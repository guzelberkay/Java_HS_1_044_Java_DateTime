package com.berkay;

import java.time.*;
import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        /**
         * Java da Zaman kavramı ve Kullanımlar.
         * - Bir kullanıcının doğum tarihi
         * - Bir satis isleminin gerçekleşme zamani
         * - Bir kullanıcının kayıt ,güncelleme ya da silinme tarihlerinde
         * - Uygulamanın çalışma başlama zamanı
         * - Zamanlanmış görevlerin baslama, tekrarlama ya da bitiş zamanları
         * new Date();
         * JVM in configlerine göre üzerinde çalışmakta olduğu Pc nin tarih ve saatini kullanır
         *
         * Date -> gün ay yıl
         * Tıme -> saat dakika saniye ms
         */

        Date date = new Date();
        /**
         * Bir method "Deprecated" ile işaretenmiş ise ilerleyen sürümlerde artık
         * kullanılmayacak demektir. Bu nedenle bu methodu kullanırken dikkatli olmak gerekir.
         * Çünkü ilerleyen sürümlerde uygulamanız çalışmaz hale gelecektir.
         *
         */
        // date.getHours(); deprecated
        System.out.println("Suan ki an...: " + date);
        System.out.println("Suan ki time...: " + date.getTime()); // long to date
        /**
         * LocalDate - Time - DateTime
         * ZonedDateTme
         */
        System.out.println("Local Date........: " + LocalDate.now());
        System.out.println("Local Time........: " + LocalTime.now());
        System.out.println("Local Date Time...: " + LocalDateTime.now());
        System.out.println("Zoned Date Time...: " + ZonedDateTime.now());

        /**
         * Zamanı Long olarak kullanmak ne demektir ve bize ne gibi faydaları olur.
         * Long zaman dilinin bir başlangıç tarihi vardır ve o tarihten günümüze geçen ms. cinsinden
         * zamanı iletir
         * Başlangıç zamanı 01/01/1970 tir ve bu tarihten günümüze geçen süreyi long olarak iletir.
         *
         */
        long start = 0;
        System.out.println("0 Long zamanı nedir? ....: " + new Date(start));
        start = 1710674898319L;
        System.out.println("Belli bir zaman ...: " + new Date(start));

        /**
         *  Suan içinde bulunduğumuz zamanı long olarak almak için genellikle System kullanılır.
         *  Suan dan 3 saat 10 dk sonrası nasıl hesaplanır?
         *  1sn = 1000ms
         *  1dk = 60sn
         *  1saat = 60dk
         *
         */
        long now = System.currentTimeMillis();
        long saat = 1000L * 60 * 60;
        long dakka = 1000L * 60;
        long afterTime = saat * 3 + dakka * 10;
        System.out.println("suan......................: " + new Date());
        System.out.println("3 saat 10 dakika sonra....: " + new Date(now + afterTime));

        /**
         *
         * Local Date - Time methodları kullanmak
         * Belli bir zaman dilimi itibaren işlem yapmak ve ilerlemek istiyorsunuz
         * bunu hesaplayabilmek için bir başlangıç noktasına ihtiyacınız var.
         * Bu Date ya da long ile yapmak biraz sorun teşkil edebilir bu nedenle LocalDate
         * kullanmak daha verimli olur
         */

        LocalDate localDate = LocalDate.of(2024, 4, 4);
        System.out.println("local Date .....: " + localDate);
        localDate = LocalDate.of(2024, Month.JANUARY, 6);
        System.out.println("local date .....: "+localDate);
        LocalTime localTime = LocalTime.of(20,43,23,321541223);
        System.out.println("Local time .....: "+localTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(1999,6,23,18,11,6,4334,ZoneId.of("Europe/Istanbul"));
        System.out.println("Istanbu/Avrupa..: "+zonedDateTime);
        /**
         *
         * Bazan uygulamalarda , özellikle tarih ile ilgili aramalarda belli zaman aralıkları
         * belirterek arama yapılabilir.
         * Belli gün, ay  ya da yılları kullanarak listelemeler yapılır. Bunları elle kontrol etmek
         * ya ilerletmek sorunlu sonuçlar doğurabilir. Bu nedenle daha kullanıslı yapıları tercih etmeliyiz.
         * Local -date-time kendi bünyesinde bu tarihleri kolaylıkla manipule etmenizi sağlayan
         * methodlara sahiptir
         */
        LocalDate localDateNow = LocalDate.now();
        System.out.println("bugun.............................................: "+localDateNow);
        System.out.println("Bu gunden 18 gun sonrası hangi gume denk gelir ...: "+localDateNow.plusDays(18));
        System.out.println("Bu gunden 5 hafta sonrası hangi gun ..............: "+localDateNow.plusWeeks(5));
        System.out.println("Bu gunden 5 ay oncesi.............................: "+localDateNow.minusMonths(5));
        /**
         *
         * Bazen belli periyotlarda işlem yapak isteyebiliriz. Mesela bir iş günümüz olsun bu iş döngüsü
         * her 6 günde bir tekrar etsin ve görev atasın.
         * Örneğin bir nöbet cizlgesinde insanların tutacakları nöbetlerin döngüsü olsun. 12 kişilik bir listede
         * her kisi 6 gün de bir nöbet tutuyor ise bana sıra gelecek günleri hesaplayabilirim
         */
        Period period = Period.ofDays(6);
        System.out.println("Su an ..............: "+localDateNow);
        System.out.println("1. periyod .........: "+localDateNow.plus(period).plus(period));
        /**
         * Uygulamaların çalışma zamanın test etmek için kullanmakta olduğum bir yapıyı inceleyelim.
         * Genellikle bu tarz işlemler hızlı sonuc almak almak için yapılır, fikir verebilir ancak net
         * bir sonuc için test aracları JavaProfiler gibi yöntemleri denemek doğr olacaktır.
         *
         */
        long startSecond = System.currentTimeMillis();
        long startNano = System.nanoTime();
        Instant startInstant = Instant.now();
        long toplam = 0;
        for (int i = 0; i < 1_000_000_000L; i++) {
            toplam += i;
        }
        System.out.println("Toplam......: "+toplam);
        long endSecond = System.currentTimeMillis();
        long endNano = System.nanoTime();
        Instant endInstant = Instant.now();
        System.out.println("ms sure......: "+(endSecond-startSecond));
        System.out.println("ns sure......: "+(endNano-startNano));
        Duration duration = Duration.between(startInstant,endInstant);
        System.out.println("duration.....: "+duration.getNano());
        System.out.println("duration.....: "+duration.getSeconds());



    }
}
