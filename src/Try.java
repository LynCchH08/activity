import java.util.Scanner;

public class Try {

    public static String generateOtp() {
        long systemTime = System.currentTimeMillis();
        String otpValue = String.valueOf(systemTime % 1000000);
        return String.format("%06d", Long.parseLong(otpValue));
    }


    public static void simulateOtpSending(String phone, String otp) {
        System.out.println("OTP sent to " + phone + ": " + otp);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);


        System.out.println("Please enter your phone number:");
        String userPhoneNumber = inputScanner.nextLine();


        String generatedOtp = generateOtp();

        simulateOtpSending(userPhoneNumber, generatedOtp);

        System.out.println("Please enter the OTP sent to your phone number for verification:");
        String userEnteredOtp = inputScanner.nextLine();


        if (userEnteredOtp.equals(generatedOtp)) {
            System.out.println("Account successfully verified!");
        } else {
            System.out.println("Incorrect OTP. Please try again.");
        }

        inputScanner.close();
    }
}
