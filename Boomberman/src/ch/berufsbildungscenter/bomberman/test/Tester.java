package ch.berufsbildungscenter.bomberman.test;

import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.berufsbildungscenter.bomberman.main.Block;
import ch.berufsbildungscenter.bomberman.main.Field;
import ch.berufsbildungscenter.bomberman.main.PlayerData;
import ch.berufsbildungscenter.bomberman.main.Receiver;
import ch.berufsbildungscenter.bomberman.main.ReceiverImpl;
import ch.berufsbildungscenter.bomberman.main.Timer;

public class Tester {
	private Field field;
	private Receiver receiver;
	private PlayerData playerData;

	@Before
	public void setUp() throws Exception {
		this.setField(new Field());
		this.setReceiver(new ReceiverImpl(this.getField()));
		this.getField().load("map1");
		this.setPlayerData(new PlayerData((ImageIcon) Block.loadIcon("player1front.png"), 1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Timer t = new Timer();
		Assert.assertEquals(120, t.getTime());

	}

	@Test
	public void test2() {

		try {
			Assert.assertEquals(1, this.getReceiver().sendPlayer().getPlayerNr());
			Assert.assertEquals(2, this.getReceiver().sendPlayer().getPlayerNr());
		} catch (RemoteException e) {

		}
	}

	@Test
	public void test3() {
		int[] i = { 0, 0 };
		Assert.assertEquals(i[0], this.getField().findIndex(this.getField().get(0, 0))[0]);
		Assert.assertEquals(i[1], this.getField().findIndex(this.getField().get(0, 0))[1]);
	}

	@Test
	public void test4() {
		this.getPlayerData().setName("Peter");
		Assert.assertEquals("Peter", this.getPlayerData().getNameLabel().getText());
	}

	public PlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerData playerData) {
		this.playerData = playerData;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

}
