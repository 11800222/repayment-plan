//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package uncle.drew.repayment.plan.infrastructure.service;


import interfaces.UserCardInfoService;
import uncle.drew.repayment.plan.domain.model.plan.ScheduleLimits;
import vo.CardInfo;

import javax.annotation.Resource;

public class RPCUserAdapter implements UserAdapter {

    @Resource
    private UserCardInfoService userCardInfoService;


    @Override
    public ScheduleLimits toScheduleLimits(Long cardId) {
        CardInfo userCardInfo = userCardInfoService.getUserCardInfo(cardId);
        //
        return null;
    }
}