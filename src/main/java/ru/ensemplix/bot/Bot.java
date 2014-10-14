package ru.ensemplix.bot;

import org.spacehq.mc.auth.exception.AuthenticationException;
import org.spacehq.mc.protocol.MinecraftProtocol;
import org.spacehq.mc.protocol.packet.ingame.client.ClientChatPacket;
import org.spacehq.packetlib.Client;
import org.spacehq.packetlib.Session;
import org.spacehq.packetlib.tcp.TcpSessionFactory;
import ru.ensemplix.bot.attribute.Watcher;
import ru.ensemplix.bot.attribute.Move;

import java.net.ConnectException;

public class Bot {

    /**
     * Игровой ник.
     */
    private String name;

    /**
     * Пароль для прохождения авторизации. Если сервер работает
     * в оффлайн режиме то пароль не нужен.
     */
    private String password;

    /**
     * Активная игровая сессия бота.
     */
    private Session session;

    /**
     * Обработчик движений бота.
     */
    private Move move;

    /**
     * Обработчик существ которые находятся в зоне видимости бота.
     */
    private Watcher watcher;

    public Bot(String name) {
        this.name = name;
    }

    public Bot(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Подключиться к серверу на указанном хосте и порте.
     */
    public void connect(String host, int port) throws AuthenticationException, ConnectException {
        if(session.isConnected()) {
            throw new ConnectException("Player already in game");
        }

        MinecraftProtocol protocol = new MinecraftProtocol(name, password, false);
        Session session = new Client(host, port, protocol, new TcpSessionFactory()).getSession();

        session.addListener(new Move());
        session.connect();
    }

    /**
     * Отключиться от сервера.
     */
    public void disconnect() {
        session.disconnect(null);
    }

    /**
     * Отправить сообщение на сервер.
     */
    public void sendMessage(String message) {
        session.send(new ClientChatPacket(message));
    }

    /**
     * Переместить игрока на указанные координаты.
     */
    public void move(int x, int y, int z) {
        move.move(x, y, z);
    }

    /**
     * Обработчик движений игрока.
     */
    public Move getMove() {
        return move;
    }

    /**
     * Обработчик существ которые находятся в зоне видимости игрока.
     */
    public Watcher getWatcher() {
        return watcher;
    }

}
