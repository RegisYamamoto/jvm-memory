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
		
		//o intellij ja traz os importas automaticamente referente a memória
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        //Aqui há uma identificação de memória com resposta HEAP
        System.out.println(":::::Memória heap:::::");
        System.out.println();
        MemoryUsage heapMemory = memoryMXBean.getHeapMemoryUsage();

        System.out.println("Tamanho Inicial :: " + heapMemory.getInit() +
                String.format(Locale.US, FORMAT,(double) heapMemory.getInit() / MEGA));
        System.out.println("Tamanho atual :: " +
                heapMemory.getInit() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getCommitted() / MEGA));
        System.out.println("Usado :: " +heapMemory.getUsed() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getUsed() / MEGA));
        System.out.println("Máximo :: " + heapMemory.getMax() +
                String.format(Locale.US, FORMAT, (double) heapMemory.getMax() / MEGA));
        System.out.println();

        //AGORA VAMOS FAZER PRATICAMENTE A MESMA COISA PORÉM COM A MEMÓRIA NON-HEAP
        System.out.println(":::Memória non-heap:::");
        System.out.println();
        MemoryUsage nonheapMemory = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("Tamanho inicial ::" + nonheapMemory.getInit() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getInit() / MEGA));
        System.out.println("Tamanho Atual ::" + nonheapMemory.getCommitted() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getCommitted() / MEGA));
        System.out.println("Usado ::" + nonheapMemory.getUsed() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getUsed() / MEGA));
        System.out.println("Máximo ::" + nonheapMemory.getMax() +
                String.format(Locale.US, FORMAT, (double) nonheapMemory.getMax() / MEGA));
        System.out.println();


        // Funcionamento do pool de memórias na JVM
        System.out.println(":: Pool de memórias Organ. JVM ::");
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
            System.out.println("Máximo: " + usage.getMax() +
                    String.format(Locale.US, FORMAT, (double) usage.getMax() / MEGA));
            System.out.println();
        }

	}

}