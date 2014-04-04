package com.bibliocommons.sshwar

import net.schmizz.sshj.SSHClient

object SshSession {

	val client = new SSHClient
	client.loadKnownHosts()

	def startSession() : String = {

		try {

			client.disconnect()
			client.connect("localhost")

			val session = client.startSession()
			val command = session.exec("date")
			command.getInputStream().toString()

		} catch {

			case e : Throwable => e.getMessage()

		} finally {
			client.disconnect()
		}

	}

}