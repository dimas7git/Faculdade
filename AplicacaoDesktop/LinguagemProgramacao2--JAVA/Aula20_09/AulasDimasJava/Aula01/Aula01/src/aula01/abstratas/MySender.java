package aula01.abstratas;

public class MySender extends AbstractEncodedMessageSender {

	@Override
	public String encode(String message) {
		String ret = message;
		return ret;
	}

	public static void main(String[] args) {
		AbstractEncodedMessageSender sender = new MySender();
		sender.sendMessage("Ola Mundo!!!");

		// Classe anônima
		AbstractEncodedMessageSender otherSender = new AbstractEncodedMessageSender() {

			@Override
			public String encode(String message) {
				String ret = message;
				return ret;
			}
		};

		otherSender.sendMessage("Ola mundo pela segunda vez!!!");

		System.out.println(sender.getClass());
		System.out.println(otherSender.getClass());
	}
}
