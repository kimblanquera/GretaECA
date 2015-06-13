echo Mary
cd .\MARYTTS_4.3.1\bin
start /MIN maryserver.bat
cd ../..
utils\WAIT.exe 2
echo Psyclone
cd .\psyclone\
start /MIN psyclone spec="GretaEVOSpec.xml" verbose=0
cd ..
utils\WAIT.exe 2
echo starting Greta :
start /MIN Psyclone_ClockDebug.exe
utils\WAIT.exe 1
start /MIN Psyclone_BehaviorPlannerDebug_New_Eng.exe
utils\WAIT.exe 1
start /MIN Psyclone_BehaviorRealizerDebug_New_Eng.exe
utils\WAIT.exe 1
start Player.exe
::utils\WAIT.exe 1
::start Psyclone_WoZ.exe
utils\WAIT.exe 1
cd .\BML_FML_LOADER
java -classpath ./;./AbsoluteLayout.jar;./JavaAIRPlug.jar;./interface.jar interfacepkg.NewJFrame

:: the console wait for the end of the java interface
:: when we close it, all applications are killed :

taskkill /f /im Player.exe
::taskkill /f /im Psyclone_WoZ.exe
taskkill /f /im Psyclone_BehaviorRealizerDebug_New_Eng.exe
taskkill /f /im Psyclone_BehaviorPlannerDebug_New_Eng.exe
taskkill /f /im Psyclone_ClockDebug.exe
taskkill /f /im psyclone.exe
taskkill /f /im java.exe
taskkill /f /im cmd.exe
