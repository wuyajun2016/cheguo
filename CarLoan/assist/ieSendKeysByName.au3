#Region ;**** 参数创建于 ACNWrapper_GUI ****
#AutoIt3Wrapper_UseUpx=n
#AutoIt3Wrapper_Res_Fileversion=0.0.0.0
#EndRegion ;**** 参数创建于 ACNWrapper_GUI ****

#include <IE.au3>

If $CmdLine[0] < 6 Then 
	Exit
EndIf

ieSendKeysByName($CmdLine[1], $CmdLine[2], $CmdLine[3], $CmdLine[4], $CmdLine[5], $CmdLine[6])

Func ieSendKeysByName($windowTitle, $winIndex, $name, $index, $text, $timeout)	
	WinWait($windowTitle, "", $timeout)
	If  WinExists($windowTitle) Then
		WinWaitActive($windowTitle, "", 5)
		
		$Browser = _IEAttach ($windowTitle, "Title", $winIndex)
		If @error Then
			Exit
		EndIf
		
		$Object = _IEGetObjByName($Browser, $name, $index)
		If @error Then
			Exit
		EndIf
		
		_IEDocInsertText($Object, $text)		
		If @error Then
			Exit
		EndIf
	Else
		Return False
	EndIf
EndFunc