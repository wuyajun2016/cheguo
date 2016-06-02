package com.framework.support;

import org.apache.log4j.Logger;

import com.framework.executor.ThreadExecutor;

/**
 * ˵���� 1������AUTOITʵ�ֵ�GUI�������������Ϊ��֪�Գ���
 * 2�������ء����ء��ر�Dialog�����Dialog����Dialog�������ı��Ȳ�����
 * 
 */

public class Win32GuiByAu3 {

	private static final String ASSIST = System.getProperty("user.dir")
			+ "/assist/";
	private final ThreadExecutor execute = new ThreadExecutor();
	private final long orgTimeout = execute.getThreadTimeOut();
	private Logger LOG = Logger.getLogger(Win32GuiByAu3.class);

	/**
	 * Description: if user need to use time longer than default timeout
	 * setting, change to max.
	 * 
	 * @param timeout
	 *            timeout setting.
	 */
	private void setExecuteTimeout(int timeout) {
		if (timeout * 1000 > execute.getThreadTimeOut()) {
			execute.setThreadTimeOut(timeout * 1000);
		}
	}

	/**
	 * Description: reset the default timeout setting.
	 */
	private void setOrginalTimeout() {
		execute.setThreadTimeOut(orgTimeout);
	}

	/**
	 * upload file in win32 gui using autoit compiled exe</BR> you can use it
	 * like this: fileUpload("ѡ���ļ�", "D:\\a.txt", 5);
	 * 
	 * @param title
	 *            dialog title
	 * @param fileName
	 *            file from where to upload
	 * @param timeout
	 *            timeout setting for wait alert appears in second unit
	 * @throws RuntimeException
	 */
	public void fileUpload(String title, String fileName, int timeout) {
		String fileExec = ASSIST + "Upload.exe";
		String cmd = "\"" + fileExec + "\" \"" + title + "\" \"" + fileName
				+ "\" \"" + timeout + "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
			closeWindow(title, 1);
		}
	}

	/**
	 * upload file in win32 gui using autoit compiled exe</BR> wait for upload
	 * dialog appers in 20 seconds</BR> you can use it like this:
	 * fileUpload("ѡ���ļ�", "D:\\a.txt");
	 * 
	 * @param title
	 *            dialog title
	 * @param fileName
	 *            file from where to upload
	 * @throws RuntimeException
	 */
	public void fileUpload(String title, String fileName) {
		fileUpload(title, fileName, 20);
	}

	/**
	 * download file in win32 gui using autoit compiled exe</BR> you can use it
	 * like this: fileDownload("�ļ�����", "���Ϊ", "D:\\download.csv", 30);
	 * 
	 * @param fstTitle
	 *            the first download dialog title
	 * @param sndTitle
	 *            the second dialog after click "Save"
	 * @param saveAs
	 *            file name to be saved as
	 * @param timeout
	 *            download window wait timeout setting
	 * @throws RuntimeException
	 */
	public void fileDownload(String fstTitle, String sndTitle, String saveAs,
			int timeout) {
		String fileExec = ASSIST + "Download.exe";
		String cmd = "\"" + fileExec + "\" \"" + fstTitle + "\" \"" + sndTitle
				+ "\" \"" + saveAs + "\" \"" + timeout + "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
			closeWindow(fstTitle, 1);
			closeWindow(sndTitle, 1);
		}
	}

	/**
	 * download file in win32 gui using autoit compiled exe</BR> wait for
	 * download dialog appers in 20 seconds</BR> you can use it like this:
	 * fileDownload("�ļ�����", "���Ϊ", "D:\\download.csv");
	 * 
	 * @param fstTitle
	 *            the first download dialog title
	 * @param sndTitle
	 *            the second dialog after click "Save"
	 * @param saveAs
	 *            file name to be saved as
	 * @throws RuntimeException
	 */
	public void fileDownload(String fstTitle, String sndTitle, String saveAs) {
		fileDownload(fstTitle, sndTitle, saveAs, 20);
	}

	/**
	 * click alert dialog in win32 gui using autoit compiled exe</BR> you can
	 * use it like this: clickAlert("��ʾ��Ϣ", "ȷ��(Y)", 10);
	 * 
	 * @param dialogTitle
	 *            dialog title
	 * @param buttonName
	 *            the button name/text on the dialog to click
	 * @param timeout
	 *            timeout setting for wait alert appears in second unit
	 * @throws RuntimeException
	 */
	public void clickAlert(String dialogTitle, String buttonName, int timeout) {
		String fileExec = ASSIST + "ClickAlert.exe";
		String cmd = "\"" + fileExec + "\" \"" + dialogTitle + "\" \""
				+ buttonName + "\" \"" + timeout + "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
			closeWindow(dialogTitle, 1);
		}
	}

	/**
	 * click alert dialog in win32 gui using autoit compiled exe</BR> wait for
	 * alert appers in 5 seconds</BR> you can use it like this:
	 * clickAlert("��ʾ��Ϣ", "ȷ��(Y)");
	 * 
	 * @param dialogTitle
	 *            dialog title
	 * @param buttonName
	 *            the button name/text on the dialog to click
	 * @throws RuntimeException
	 */
	public void clickAlert(String dialogTitle, String buttonName) {
		clickAlert(dialogTitle, buttonName, 5);
	}

	/**
	 * type text in alert dialog in win32 gui using autoit compiled exe</BR> you
	 * can use it like this: typeAlert("���ڱ���", "Edit1", "��������", 5);
	 * 
	 * @param title
	 *            init dialog title
	 * @param locator
	 *            the locator on the dialog
	 * @param text
	 *            text to put into the edit
	 * @param timeout
	 *            timeout setting for wait alert appears in second unit
	 * @throws RuntimeException
	 */
	public void typeAlert(String title, String locator, String text, int timeout) {
		String fileExec = ASSIST + "TypeAlert.exe";
		String cmd = "\"" + fileExec + "\" \"" + title + "\" \"" + locator
				+ "\" \"" + text + "\" \"" + timeout + "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
			closeWindow(title, 1);
		}
	}

	/**
	 * type text in alert dialog in win32 gui using autoit compiled exe</BR>
	 * wait for alert appers in 5 seconds</BR> you can use it like this:
	 * typeAlert("���ڱ���", "Edit1", "��������");
	 * 
	 * @param title
	 *            init dialog title
	 * @param locator
	 *            the locator on the dialog
	 * @param text
	 *            text to put into the edit
	 * @throws RuntimeException
	 */
	public void typeAlert(String title, String locator, String text) {
		typeAlert(title, locator, text, 5);
	}

	/**
	 * close window by name in win32 gui using autoit compiled exe</BR> you can
	 * use it like this: closeWindow("���ڱ���", 5);
	 * 
	 * @param title
	 *            dialog title
	 * @param timeout
	 *            timeout setting for wait alert appears in second unit
	 * @throws RuntimeException
	 */
	public void closeWindow(String title, int timeout) {
		String fileExec = ASSIST + "CloseWindow.exe";
		String cmd = "\"" + fileExec + "\" \"" + title + "\" \"" + timeout
				+ "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
		}
	}

	/**
	 * close window by name in win32 gui using autoit compiled exe</BR> wait for
	 * alert appers in 5 seconds</BR> you can use it like this:
	 * closeWindow("���ڱ���");
	 * 
	 * @param title
	 *            dialog title
	 * @throws RuntimeException
	 */
	public void closeWindow(String title) {
		closeWindow(title, 5);
	}

	/**
	 * activate window by name in win32 gui using autoit compiled exe</BR> you
	 * can use it like this: activateWindow("���ڱ���", 5);
	 * 
	 * @param title
	 *            dialog title
	 * @param timeout
	 *            timeout setting for wait alert appears in second unit
	 * @throws RuntimeException
	 */
	public void activateWindow(String title, int timeout) {
		String fileExec = ASSIST + "ActivateWindow.exe";
		String cmd = "\"" + fileExec + "\" \"" + title + "\" \"" + timeout
				+ "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
		}
	}

	/**
	 * activate window by name in win32 gui using autoit compiled exe</BR> you
	 * can use it like this: activateWindow("���ڱ���");
	 * 
	 * @param title
	 *            dialog title
	 * @throws RuntimeException
	 */
	public void activateWindow(String title) {
		activateWindow(title, 5);
	}

	/**
	 * get and write browser message to file using autoit compiled exe</BR> you
	 * can use it like this: assertErrors(title, "errorMessage", "li",
	 * "D:\\a.txt", 10);
	 * 
	 * @param title
	 *            pop window title
	 * @param upIdName
	 *            the id or name of the text's father element
	 * @param eleType
	 *            the type of the element which to get text
	 * @param fileName
	 *            file path and name to store the error text
	 * @param timeout
	 *            time out setting to find the pop window
	 * @throws RuntimeException
	 */
	public void assertErrors(String title, String upIdName, String eleType,
			String fileName, int timeout) {
		String execName = ASSIST + "WriteErrorMessage.exe";
		String cmd = "\"" + execName + "\" \"" + title + "\" \"" + upIdName
				+ "\" \"" + eleType + "\" \"" + fileName + "\" \""
				+ String.valueOf(timeout) + "\"";
		try {
			setExecuteTimeout(timeout);
			execute.executeCommands(cmd);
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			setOrginalTimeout();
			closeWindow(title, 1);
		}
	}
}
