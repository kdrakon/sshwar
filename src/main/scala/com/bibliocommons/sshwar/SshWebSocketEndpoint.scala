package com.bibliocommons.sshwar

import org.atmosphere.websocket.WebSocketHandlerAdapter
import org.atmosphere.util.SimpleBroadcaster
import org.atmosphere.config.service.WebSocketHandlerService
import org.atmosphere.websocket.WebSocket
import java.io.IOException
import org.atmosphere.cpr.BroadcasterFactory
import org.atmosphere.websocket.WebSocketProcessor

@WebSocketHandlerService(path = "/websocket/ssh", broadcaster = classOf[ SimpleBroadcaster ])
class SshWebSocketEndpoint extends WebSocketHandlerAdapter {

	@throws[ IOException ]
	override def onOpen(webSocket : WebSocket) {

		try {

			val out = SshSession.startSession()
			webSocket.write(out)

		} catch {
			case e : Throwable => webSocket.write(e.getMessage())
		}

	}

	override def onClose(webSocket : WebSocket) {
		webSocket.write("\n[closed connection]")
	}

	override def onError(webSocket : WebSocket, t : WebSocketProcessor.WebSocketException) {
		webSocket.write(t.getMessage())
	}

	@throws[ IOException ]
	override def onTextMessage(webSocket : WebSocket, data : String) {

		webSocket.write(data)
	}

}