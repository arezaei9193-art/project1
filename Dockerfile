# استفاده از JDK 25 رسمی
FROM openjdk:25-jdk

# پوشه کاری داخل کانتینر
WORKDIR /app

# کپی کردن سورس‌ها به کانتینر
COPY src /app/src

# کامپایل کردن فایل‌های جاوا
RUN javac src/*.java -d /app/out

# تعیین کلاس اصلی برای اجرا
CMD ["java", "-cp", "out", "Main"]
