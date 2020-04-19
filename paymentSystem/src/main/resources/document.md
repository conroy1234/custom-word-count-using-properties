Programming Test
Tackle as many of these as you can in the time allocated, emphasis will be
placed on style and structure rather than syntax and completeness.
Java Questions
Question 1
Below is a extract from two classes used with in a pricing system. The first
class ‘InterestPayment’ contains some business logic; the second class
‘Payment’ is a POJO that represents a payment. The specification of business
logic in InterestPayment.updatePayment() is to update the payment if the date is
within 5 days of the existing date and return true if it was updated (otherwise a
new payment would be created and the existing payment would remain).
There is a bug in the updatePayment method. Write a Junit test case to expose
the bug.
public class InterestPayment
{
 private static int PAYMENT_DAY_TOLERANCE = 5;
 private Payment currentPayment;
 /**
 * Update the payment if and only if the new payment is
 * within 5 days of the existing payment.
 *
 * @param payment The new payment
 * @return True if the payment was updated, false otherwise.
 */
 public boolean updatePayment(Payment payment)
 {
 if (payment.getDayNumber() - currentPayment.getDayNumber()
< PAYMENT_DAY_TOLERANCE)
 {
 this.currentPayment = payment;
 return true;
 }

 return false;
 }
}
public class Payment
{
 /* The number of days after 1/1/1970 */
 private long dayNumber;
 private BigDecimal rate;
 public Payment(long dayNumber, BigDecimal rate)
 {
 this.dayNumber = dayNumber;
 this.rate = rate;
 }
 public long getDayNumber()
 {
 return dayNumber;
 }
}
2
Question 2
Below are classes from a program that receive, parse and store messages
from European stock exchanges. The program uses JPA, to persist the POJO
objects. The persistence code already exists. Complete the
TradeParser.parse method class so the unit tests pass, add any other
unit tests you feel would be appropriate.
The TradeParser.parse() method is passed a message at a time. It shall
parse each message returning a Trade object where possible; otherwise an
exception is to be thrown. Each message consists of a number of fields
delimited by a semi-colon. A field is identified by a single character, followed
by the field value. In this application the code is only interested in three fields
from the message.
Field Code Description
i ISIN code, 12 characters
p Trade price, decimal
t Trade number, integer
So the following
iIT0004158397;p123.45;t1
is a message for message for ISIN IT0004158397, price 123.45, type 1;
public class TradeParser
{
 public static Trade parse(String line) throws Exception {
 Trade trade = new Trade();
 // TODO: Write trade parser
 return trade;
 }
}
3
import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "trades")
public class Trade {
 @Id
 @GeneratedValue(strategy= GenerationType.AUTO)
 @Column(name = "trade_id", updatable = false)
 private long id;
 @Column(name = "isin", nullable = false, length = 12)
 private String isin;
 public String getIsin() {
 return isin;
 }
 public void setIsin(String isin) {
 this.isin = isin;
 }
 @Column(name = "trade_type", nullable = false)
 private Integer type;
 public Integer getType() {
 return type;
 }
 public void setType(Integer type) {
 this.type = type;
 }
 @Column(name = "trade_type", nullable = false)
 private BigDecimal price;
 public BigDecimal getPrice() {
 return price;
 }
 public void setPrice(BigDecimal price) {
 this.price = price;
 }
}
4
import junit.framework.TestCase;
import java.math.BigDecimal;
public class TestTradeParser extends TestCase {
 public void testXetra() throws Exception {
 Trade trade = TradeParser.parse("iIT1234567890;t1;p123.34");
 assertEquals("IT1234567890", trade.getIsin());
 assertEquals(new Integer(1), trade.getType());
 assertEquals(new BigDecimal("123.34"), trade.getPrice());
 }
 public void testLSE() throws Exception {
 Trade trade = TradeParser.parse("t1;iGB1234567890;p123.34");
 assertEquals("GB1234567890", trade.getIsin());
 assertEquals(new Integer(1), trade.getType());
 assertEquals(new BigDecimal("123.34"), trade.getPrice());
 }
 public void testLIFFE() throws Exception {
 Trade trade = TradeParser.parse("t1;iGB1234500367890;p123.34;v1000");
 assertEquals("GB1234567890", trade.getIsin());
 assertEquals(new Integer(1), trade.getType());
 assertEquals(new BigDecimal("123.34"), trade.getPrice());
 }
 public void testError1() {
 try {
 Trade trade = TradeParser.parse("iGB1234567890;p123.34");
 fail("Expected exception");
 }
 catch (Exception e) {}
 }
 public void testError2(){
 try {
 Trade trade = TradeParser.parse("iGB12345678901;p123.34;t1");
 fail("Expected exception");
 }
 catch (Exception e) {}
 }
 public void testError3(){
 try {
 Trade trade = TradeParser.parse("iGB12345678901;t2;p123.34;t1");
 fail("Expected exception");
 }
 catch (Exception e) {}
 }
}
5
Question 3
BondDataProcessor is a program that parses a file containing end-of-day
records. The program reads the file a line at a time. It parses each line into a
Bond POJO and stores this to a database. Due to an increase in daily volume,
this now process is taking too long. Profiling of the application has shown that
the BondRecordParser.parseBond() method is CPU intensive. The program
runs on a multi-core server. Change the program to exploit this.
Issues outside our control mean only one instance of the BondDAO
implementation can exist within a JVM and BondDAO.store() is not know to
be thread safe.
import java.io.BufferedReader;
import java.io.FileReader;
public class BondDataProcessor {
 static BondDAO bondDAO;
 BondRecordParser bondRecordParser;
 public static void main(String[] args) {
 try {
 BufferedReader bufferedReader =
new BufferedReader(new FileReader(args[0]));
 bondDAO = BondDAOFactory.createBondDAO();

 BondDataProcessor dataProcessor = new BondDataProcessor();

 String line = bufferedReader.readLine();
 while (line != null) {
 dataProcessor.processLine(line);
 }
 }
 catch (Throwable t) {
 t.printStackTrace();
 }
 }
 public BondDataProcessor() {
 bondRecordParser = new BondRecordParser();
 }
 private void processLine(String line) {
 final Bond bond = bondRecordParser.parseBond(line);
 bondDAO.store(bond);
 }
}
6
public class BondRecordParser
{
 public Bond parseBond(String line) {
 // Do stuff
 return new Bond();
 }
}
public class Bond {
}
public interface BondDAO {
 public void store(Bond bond);
}
Javascript Questions
Question 4.
Given the below generator function write a code which prints to the console each of
the values in it. 