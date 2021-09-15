#6.	Retrieve the names, addresses, and number of books checked out for all borrowers who have more than five books checked out. 
select name, address, count(*) as total
from tbl_borrower
join tbl_book_loans on tbl_borrower.cardNo = tbl_book_loans.cardNo
group by tbl_borrower.name having total > 5;