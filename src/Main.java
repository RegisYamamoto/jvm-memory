import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;
import java.util.Locale;

public class Main {
	
	public static int MEGA = 1024 * 1024;
    public static String FORMAT = " (%.2fmb)";

	public static void main(String[] args) {
		
		//o intellij ja traz os importas automaticamente referente a mem�ria
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        //Aqui h� uma identifica��o de mem�ria com resposta HEAP
        System.out.println(":::::Mem�ria heap:::::");
        System.out.println();
        MemoryUsage heapMemory = memoryMXBean.getHeapMemoryUsage();

        System.out.println("Tamanho Inicial :: " + heapMemory.getInit() +
                String.format(Locale.US, FORMAT,(double) heapMemory.getInit() / MEGA));
        System.out.println("Tamanho atual :: " +
                heapMemory.getInit() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getCommitted() / MEGA));
        System.out.println("Usado :: " +heapMemory.getUsed() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getUsed() / MEGA));
        System.out.println("M�ximo :: " + heapMemory.getMax() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getMax() / MEGA));
        System.out.println();

        //AGORA VAMOS FAZER PRATICAMENTE A MESMA COISA POR�M COM A MEM�RIA NON-HEAP
        System.out.println(":::Mem�ria non-heap:::");
        System.out.println();
        MemoryUsage nonheapMemory = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("Tamanho inicial ::" + nonheapMemory.getInit() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getInit() / MEGA));
        System.out.println("Tamanho Atual ::" + nonheapMemory.getCommitted() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getCommitted() / MEGA));
        System.out.println("Usado ::" + nonheapMemory.getUsed() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getUsed() / MEGA));
        System.out.println("M�ximo ::" + nonheapMemory.getMax() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getMax() / MEGA));
        System.out.println();


        // Funcionamento do pool de mem�rias na JVM
        System.out.println(":: Pool de mem�rias Organ. JVM ::");
        System.out.println();
        List<MemoryPoolMXBean> list = ManagementFactory.getMemoryPoolMXBeans();

        for (MemoryPoolMXBean m :list) {

        	System.out.println("Nome do Pool :: " + m.getName());
        	System.out.println("Grupo ::" + m.getType());
        	System.out.println();

            MemoryUsage usage = m.getUsage();
            System.out.println("Inicial: " + usage.getInit() +
                    String.format(Locale.US, FORMAT, (double) usage.getInit() / MEGA));
            System.out.println("Atual: " +usage.getCommitted() +
                    String.format(Locale.US, FORMAT, (double) usage.getCommitted() / MEGA));
            System.out.println("Usado: " + usage.getUsed() +
                    String.format(Locale.US, FORMAT, (double) usage.getUsed() / MEGA));
            System.out.println("M�ximo: " + usage.getMax() +
                    String.format(Locale.US, FORMAT, (double) usage.getMax() / MEGA));
            System.out.println();
        }

	}

}