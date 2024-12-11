// คลาส Patient สำหรับเก็บข้อมูลคนไข้ พร้อมการปรับปรุงตามเงื่อนไขที่เพิ่มเข้ามา
public class Patient {
    // ฟิลด์ของคนไข้
    private int id; // รหัสคนไข้
    private String name; // ชื่อคนไข้
    private int birthYear; // ปีเกิดของคนไข้
    private double height; // ส่วนสูงของคนไข้ (เซนติเมตร)
    private double weight; // น้ำหนักของคนไข้ (กิโลกรัม)
    private String bloodGroup; // หมู่เลือดของคนไข้
    private String phoneNumber; // เบอร์โทรศัพท์ของคนไข้

    // Constructor สำหรับกำหนดค่าเริ่มต้นของฟิลด์
    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        // ตรวจสอบว่าค่าที่ป้อนเข้ามาเป็นค่าที่ถูกต้องหรือไม่
        if (birthYear <= 0 || height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("birthYear, height , weight Positive only");
        }
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
    }

    // Getter method สำหรับดึงค่า id
    public int getId() {
        return id;
    }

    // Getter method สำหรับดึงค่า name
    public String getName() {
        return name;
    }

    // Getter method สำหรับดึงค่า birthYear
    public int getBirthYear() {
        return birthYear;
    }

    // Getter method สำหรับดึงค่า height
    public double getHeight() {
        return height;
    }

    // Getter method สำหรับดึงค่า weight
    public double getWeight() {
        return weight;
    }

    // Getter method สำหรับดึงค่า bloodGroup
    public String getBloodGroup() {
        return bloodGroup;
    }

    // Getter method สำหรับดึงค่า phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method สำหรับคำนวณอายุของคนไข้
    public int getAge(int currentYear) {
        // ตรวจสอบว่าปีปัจจุบันต้องมากกว่าหรือเท่ากับปีเกิด
        if (currentYear <= birthYear) {
            throw new IllegalArgumentException("current year must more than brith year");
        }
        return currentYear - birthYear; // คำนวณอายุ
    }

    // Method สำหรับคำนวณ BMI (ดัชนีมวลกาย)
    public double getBMI() {
        if (height <= 0 || weight <= 0) {
            // ถ้าข้อมูลไม่ถูกต้อง ให้คืนค่า 0.0
            return 0.0;
        }
        double heightInMeters = height / 100.0; // แปลงส่วนสูงเป็นหน่วยเมตร
        return weight / (heightInMeters * heightInMeters); // คำนวณ BMI
    }

    // Method สำหรับแสดงรายละเอียดของคนไข้
    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name); // แสดงชื่อคนไข้
        System.out.println("Patient Age: " + getAge(currentYear)); // แสดงอายุคนไข้
        System.out.println("Patient Height (cm): " + height); // แสดงส่วนสูงคนไข้
        System.out.println("Patient Weight (kg): " + weight); // แสดงน้ำหนักคนไข้
        System.out.println("Patient Blood Group: " + bloodGroup); // แสดงหมู่เลือดคนไข้
        System.out.println("Patient Phone Number: " + phoneNumber); // แสดงเบอร์โทรศัพท์คนไข้
        System.out.println("Patient BMI: " + getBMI()); // แสดงค่า BMI
    }

    // Main Method สำหรับทดสอบคลาส Patient
    public static void main(String[] args) {
        int currentYear = 2024; // กำหนดปีปัจจุบัน

        // ทดสอบกรณีข้อมูลถูกต้อง
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "O+", "0812345678");
        patient.displayDetails(currentYear); // เรียกใช้ method displayDetails เพื่อแสดงข้อมูลคนไข้

        System.out.println(); // เว้นบรรทัดเพื่อความชัดเจน

        // ทดสอบกรณีข้อมูลไม่ถูกต้อง (ควรเกิดข้อผิดพลาด)
        try {
            Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0, "A-", "0898765432");
            invalidPatient.displayDetails(currentYear); // จะไม่ถูกเรียกเพราะเกิดข้อผิดพลาด
        } catch (IllegalArgumentException e) {
            // แสดงข้อความข้อผิดพลาด
            System.out.println("Error: " + e.getMessage());
        }
    }
}
