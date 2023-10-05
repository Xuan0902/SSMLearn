package cn.tsx.ioc_01;

public class ClientService {
    private static final ClientService clientService = new ClientService();

    private ClientService() {
    }

    public static ClientService createInstance() {
        return clientService;
    }
}
