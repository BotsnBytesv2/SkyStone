package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp (name ="SummerProjectTeleOp")
public class SummerProjectTeleOp extends BasicOpMode_Iterative {

    public DcMotor front_left = null;
    public DcMotor front_right = null;
    public DcMotor back_left = null;
    public DcMotor back_right = null;

    DistanceSensor sensorForwardDistance = null;
    DistanceSensor sensorLeftDistance = null;
    ColorSensor Colorsensor = null;
    public Servo claw = null;

    public void init() {

        front_left = hardwareMap.get(DcMotor.class, "fl");
        front_right = hardwareMap.get(DcMotor.class, "fr");
        back_left = hardwareMap.get(DcMotor.class, "bl");
        back_right = hardwareMap.get(DcMotor.class, "br");

        sensorForwardDistance = hardwareMap.get(DistanceSensor.class, "fds");
        Colorsensor = hardwareMap.get(ColorSensor.class, "cs");
        sensorLeftDistance = hardwareMap.get(DistanceSensor.class, "lds");
        claw = hardwareMap.get(Servo.class, "cla");

    }

    public void loop() {

        double ypower = gamepad1.right_stick_y;
        double xpower = gamepad1.left_stick_x;

        if (ypower>0.25 || ypower<-0.25){
        front_left.setPower(ypower);
        back_left.setPower(ypower);
        back_right.setPower(-ypower);
        front_right.setPower(-ypower);
        }

     if (xpower>0.25 || xpower<-0.25){
         front_left.setPower(xpower);
         front_right.setPower(xpower);
         back_right.setPower(xpower);
         front_right.setPower(xpower);
     }

        float hsvValues []= {0F,0F,0F};
        final float values [] = hsvValues;
        final double Scale_Factor = 250;

        telemetry.addData("Alpha", Colorsensor.alpha());
        telemetry.addData("Red", Colorsensor.red());
        telemetry.addData("Green", Colorsensor.green());
        telemetry.addData("Blue", Colorsensor.blue());
        telemetry.addData("Hue", hsvValues[0]);
        telemetry.addData("FowardDistanceSensor", sensorForwardDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("LeftDistanceSensor", sensorLeftDistance.getDistance(DistanceUnit.CM));

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

    private void straferight() {
        front_left.setPower(1);
        front_right.setPower(1);
        back_left.setPower(-1);
        back_right.setPower(-1);
    }

    private void strafeleft() {
        front_left.setPower(-1);
        front_right.setPower(-1);
        back_left.setPower(1);
        back_right.setPower(1);

    }

    private void off (){
        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    private void run() {

        if(sensorForwardDistance.getDistance(DistanceUnit.CM)<3){
            off();
            straferight();
        } else{
            forward();
        }

    }




                    }



