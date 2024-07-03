package tv;

public class TV {
	private static final int MAX_VOLUME = 10;
	private static final int MIN_VOLUME = 0;
	private static final int NUMBER_OF_CHANNELS = 999;

	private boolean isOn;
	private int channel = 1;
	private int volume = 3;

	public boolean isOn() {
		return isOn;
	}

	public void turnOn() {
		System.out.println("   >>> Se encendió el televisor");
		isOn = true;
	}

	public void turnOff() {
		System.out.println("   >>> Se apagó el televisor");
		isOn = false;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		checkChannelNumber(channel);
		this.channel = channel;
		System.out.println("   >>> Se cambió el televisor al canal " + getChannel());
	}

	private void checkChannelNumber(int channel) {
		if (channel < 1 || channel > NUMBER_OF_CHANNELS)
			throw new IllegalArgumentException(
					String.format("El número de canal debe estar entre 1..%d: %d", NUMBER_OF_CHANNELS, channel));
	}

	public void volumeUp() {
		if (volume == MAX_VOLUME) {
			System.out.println("   >>> El volumen del televisor ya está al máximo: " + volume);
			return;
		}
		volume++;
		System.out.println("   >>> Se subió el volumen del televisor: " + volume);
	}

	public void volumeDown() {
		if (volume == MIN_VOLUME) {
			System.out.println("   >>> El volumen del televisor ya está al mínimo: " + volume);
			return;
		}
		volume--;
		System.out.println("   >>> Se bajó el volumen del televisor: " + volume);
	}

	public void channelUp() {
		setChannel(channel < NUMBER_OF_CHANNELS ? channel + 1 : 1);
	}

	public void channelDown() {
		setChannel(channel > 1 ? channel - 1 : NUMBER_OF_CHANNELS);
	}

	@Override
	public String toString() {
		String status = isOn() ? "encendido" : "apagado";
		return String.format("Televisor %s (Canal = %d, Volumen = %d)", status, channel, volume);
	}
}
