#3.	Retrieve the names of all borrowers who do not have any books checked out.
select name 
from tbl_borrower
join tbl_book_loans on tbl_borrower.cardNo != tbl_book_loans.cardNo 
Group By tbl_borrower.name