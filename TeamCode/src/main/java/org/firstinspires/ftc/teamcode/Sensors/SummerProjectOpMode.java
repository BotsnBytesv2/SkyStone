package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.SwitchableLight;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous(name ="SummerProjectOpMode")
public class SummerProjectOpMode extends LinearOpMode {

    public DcMotor front_left = null;
    public DcMotor front_right = null;
    public DcMotor back_left = null;
    public DcMotor back_right = null;

    DistanceSensor sensorForwardDistance = null;
    DistanceSensor sensorLeftDistance = null;
    ColorSensor Colorsensor = null;
    public Servo claw = null;

    public void runOpMode() {

        front_left = hardwareMap.get(DcMotor.class, "fl");
        front_right = hardwareMap.get(DcMotor.class, "fr");
        back_left = hardwareMap.get(DcMotor.class, "bl");
        back_right = hardwareMap.get(DcMotor.class, "br");

        sensorForwardDistance = hardwareMap.get(DistanceSensor.class, "fds");
        Colorsensor = hardwareMap.get(ColorSensor.class, "cs");
        sensorLeftDistance = hardwareMap.get(DistanceSensor.class, "lds");
        claw = hardwareMap.get(Servo.class, "cla");




        waitForStart();
        while (opModeIsActive()) {

            run();
           /* turnright();
            runparallel();
            turnleft();
            sense();*/

        }
    }

    private void forward() {
        front_left.setPower(1);
        front_right.setPower(-1);
        back_left.setPower(1);
        back_right.setPower(-1);
    }

    private void backward() {
        front_left.setPower(-1);
        front_right.setPower(1);
        back_left.setPower(-1);
        back_right.setPower(1);
    }

    private void turnright() {

        if (sensorLeftDistance.getDistance(DistanceUnit.CM) < 3) {
            front_left.setPower(0);
            front_right.setPower(0);
            back_left.setPower(0);
            back_right.setPower(0);

        } else {
            front_left.setPower(1);
            front_right.setPower(1);
            back_left.setPower(1);
            back_right.setPower(1);
        }
    }

    private void turnleft() {

       if(sensorForwardDistance.getDistance(DistanceUnit.CM)<3 || sensorForwardDistance.getDistance(DistanceUnit.CM)>6){
           front_left.setPower(0);
           front_right.setPower(0);
           back_left.setPower(0);
           back_right.setPower(0);
       }
       else{
           front_left.setPower(-1);
           front_right.setPower(-1);
           back_left.setPower(-1);
           back_right.setPower(-1);
         }
       }

    private void off (){
        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    private void run() {

        if(sensorForwardDistance.getDistance(DistanceUnit.CM)<21.5){
            off();
        } else{
            forward();
        }

    }

    private void runparallel() {

        if (sensorLeftDistance.getDistance(DistanceUnit.CM) > 3 || sensorLeftDistance.getDistance(DistanceUnit.CM) < 4)){
            forward();
        }
        if (sensorLeftDistance.getDistance(DistanceUnit.CM) < 3){
            front_left.setPower(1);
            front_right.setPower(0.7);
            back_left.setPower(1);
            back_right.setPower(0.7);
        }

        if (sensorLeftDistance.getDistance(DistanceUnit.CM) > 4){
            front_left.setPower(-0.7);
            front_right.setPower(-1);
            back_left.setPower(-0.7);
            back_right.setPower(-1);
        }

        if (sensorForwardDistance.getDistance(DistanceUnit.CM) < 3){
            front_left.setPower(0);
            front_right.setPower(0);
            back_left.setPower(0);
            back_right.setPower(0);

        }
    }


    private void sense(){
        float hsvValues []= {0F,0F,0F};
        final float values [] = hsvValues;
        final double Scale_Factor = 250;

        telemetry.addData("Alpha", Colorsensor.alpha());
        telemetry.addData("Red", Colorsensor.red());
        telemetry.addData("Green", Colorsensor.green());
        telemetry.addData("Blue", Colorsensor.blue());
        telemetry.addData("Hue", hsvValues[0]);

        if (Colorsensor.red()>=35) {
            off();
            claw.setPosition(1);
        } else {
            front_left.setPower(-0.3);
            front_right.setPower(0.3);
            back_left.setPower(-0.3);
            back_right.setPower(0.3);

            private void return(){
                if(sensorLeftDistance.getDistance(DistanceUnit.CM)<3){
                    off();
                    strafeleft();
                } else{
                    backward();
                    private void home(){

                    if (sensorLeftDistance.getDistance(DistanceUnit.CM)<3){
                        off()
                    }



                    }

            }

        }
    }
}


