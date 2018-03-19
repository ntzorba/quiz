#!/bin/bash


clear

while :
do
	# If error exists, display it
	if [ "$ERR_MSG" != "" ]; then
		echo "Error: $ERR_MSG"
		echo ""
	fi


	echo "1) Load Data"  
  	echo "2) Truncate Data"
	echo "3) Select Data"
	echo "4) Enter Python"
	echo "5) View Git Options"
	echo ""
	echo "0: Exit"
	echo "====================================================================="
	echo ""
	# Clear the error message
	ERR_MSG=""

	# Read the user input
	printf "Please make a choice: " $SEL ; read SEL  

	case $SEL in
		1) ./loadData.ksh > /home/ntzorba/quiz/log/load_$(date -d "today" +"%Y%m%d%H%M").log;;
		0) echo "Bye!"; exit ;;
		2) ./truncateData.ksh > /home/ntzorba/quiz/log/truncate_$(date -d "today" +"%Y%m%d%H%M").log;;
		3) ./selectData.ksh > /home/ntzorba/quiz/log/select_$(date -d "today" +"%Y%m%d%H%M").log ; cat /home/ntzorba/quiz/log/select.log ;;
		4) python;;
		5) cat /home/ntzorba/quiz/gitoptions
		*) ERR_MSG="Please enter a valid option!"
	esac


clear
done


