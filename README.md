# Restful API Test Automation

Bu proje, Restful API'ları test etmek için kullanılan bir Java projesidir. Rest Assured kütüphanesi ve TestNG test çerçevesi kullanılarak geliştirilmiştir.

## Proje Yapısı

Proje, `src` ve `test` dizinlerine sahip bir Maven projesidir. Temel bileşenleri şunlardır:

- **src/test/java**: API testlerinin yazıldığı Java test sınıflarını içerir.
- **util**: Config sınıfı gibi yardımcı sınıfları içerir.
- **config.properties**: API konfigürasyonlarını içeren bir dosyadır.

## API Testleri

Proje, iki temel API testini içerir:

1. **GetRequest**
API üzerinden bir GET isteği yapar ve dönen yanıtın durum kodunun 200 olduğunun kontrolünü sağlar.

3. **PostRequest**
API üzerinden bir POST isteği yapar, yeni bir kayıt oluşturur ve oluşturulan kaydı kontrol eder.

Her testin test datası ve konfigürasyonu `config.properties` dosyasında bulunmaktadır. Testler, bu dosyadan okunan verilerle çalışır.
