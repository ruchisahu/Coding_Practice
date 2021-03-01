#include "Test_EmailAccountMerge.h"
#include "EmailAccountsVectorBased.h"
#include "EmailAccountsVectorANdUnionFindBased.h"

void Test_EmailAccountMerge::Setup()
{
}

void Test_EmailAccountMerge::UnitTest01()
{
	EmailAccountMerge accnMerge;
	vector<vector<string>> accounts;
	vector<string> accnOne = { "John", "john@gmail.com","john@outlook.com" };
	vector<string> accnTwo = { "John", "john@yahoo.com","john@outlook.com" };

	accounts.push_back(accnTwo);
	accounts.push_back(accnOne);

	auto result = accnMerge.AccountsMerge(accounts);
}

void Test_EmailAccountMerge::UnitTest02()
{
	EmailAccountsVectorBased accnMerge;
	vector<vector<string>> accounts;
	vector<string> accnOne = { "John", "john@gmail.com","john@outlook.com" };
	vector<string> accnTwo = { "John", "john@yahoo.com","john@outlook.com" };

	accounts.push_back(accnTwo);
	accounts.push_back(accnOne);

	auto result = accnMerge.AccountsMerge(accounts);
}

void Test_EmailAccountMerge::UnitTest03()
{
	EmailAccountsVectorBased accnMerge;
	vector<vector<string>> accounts;

	accounts.push_back({ "David","David0@m.co","David1@m.co" });
	accounts.push_back({ "David","David3@m.co","David4@m.co" });
	accounts.push_back({ "David","David4@m.co","David5@m.co" });
	accounts.push_back({ "David","David2@m.co","David3@m.co" });
	accounts.push_back({ "David","David1@m.co","David2@m.co" });

	auto result = accnMerge.AccountsMerge(accounts);
}

void Test_EmailAccountMerge::UnitTest04()
{
	EmailAccountsVectorAndUnionFindBased accnMerge;
	vector<vector<string>> accounts;

	accounts.push_back({ "David","David0@m.co","David1@m.co" });
	accounts.push_back({ "David","David3@m.co","David4@m.co" });
	accounts.push_back({ "David","David4@m.co","David5@m.co" });
	accounts.push_back({ "David","David2@m.co","David3@m.co" });
	accounts.push_back({ "David","David1@m.co","David2@m.co" });

	auto result = accnMerge.AccountsMerge(accounts);
}
