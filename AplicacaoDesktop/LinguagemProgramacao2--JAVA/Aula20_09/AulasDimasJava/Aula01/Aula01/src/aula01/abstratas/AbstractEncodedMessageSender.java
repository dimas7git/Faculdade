package aula01.abstratas;

public abstract class AbstractEncodedMessageSender {

	public void sendMessage(String message) {
		System.out.println("encode message first");
		String encoded = encode(message);
		System.out.println("sending message...");
		// Here the message is sent somewhere
		System.out.println(encoded);
		System.out.println("message sent.");
	}

	public abstract String encode(String message);
}
