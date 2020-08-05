package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;

@TeleOp (name = "Claw Test")
public class claw_prototype_code extends BasicOpMode_Iterative {

    private Servo claw = null;


    @Override
    public void init(){
       claw = hardwareMap.get(Servo.class, "claw");
       claw.setPosition(0);
    }

    @Override
    public void loop(){

        boolean  open = gamepad1.a ;
        if (open){
            claw.setPosition(claw.getPosition()+0.1);
        }

        boolean close = gamepad1.b;
        if (close){
            claw.setPosition(claw.getPosition()-0.1);
        }

        telemetry.addData("Claw Position","value:"+claw.getPosition());
        }

}
